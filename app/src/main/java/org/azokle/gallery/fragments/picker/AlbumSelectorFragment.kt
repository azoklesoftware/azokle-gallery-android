/*
 * SPDX-FileCopyrightText: 2024 Azokle Private Limited
 * SPDX-License-Identifier: Apache-2.0
 */

package org.azokle.gallery.fragments.picker

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.azokle.gallery.R
import org.azokle.gallery.ext.getViewProperty
import org.azokle.gallery.recyclerview.AlbumThumbnailAdapter
import org.azokle.gallery.recyclerview.AlbumThumbnailLayoutManager
import org.azokle.gallery.utils.PermissionsGatedCallback
import org.azokle.gallery.utils.PickerUtils
import org.azokle.gallery.viewmodels.AlbumsViewModel
import org.azokle.gallery.viewmodels.QueryResult

class AlbumSelectorFragment : Fragment(R.layout.fragment_picker_album_selector) {
    // View models
    private val model: AlbumsViewModel by viewModels {
        AlbumsViewModel.factory(
            requireActivity().application,
            mimeType,
        )
    }

    // Views
    private val albumsRecyclerView by getViewProperty<RecyclerView>(R.id.albumsRecyclerView)
    private val noMediaLinearLayout by getViewProperty<LinearLayout>(R.id.noMediaLinearLayout)

    // Intent data
    private val mimeType by lazy { PickerUtils.translateMimeType(activity?.intent) }

    // Recyclerview
    private val albumThumbnailAdapter by lazy {
        AlbumThumbnailAdapter { album ->
            findNavController().navigate(
                R.id.action_pickerAlbumSelectorFragment_to_pickerMediaSelectorFragment,
                MediaSelectorFragment.createBundle(album.id)
            )
        }
    }

    // Permissions
    private val permissionsGatedCallback = PermissionsGatedCallback(this) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                model.albums.collectLatest {
                    when (it) {
                        is QueryResult.Data -> {
                            albumThumbnailAdapter.submitList(it.values)

                            val noMedia = it.values.isEmpty()
                            albumsRecyclerView.isVisible = !noMedia
                            noMediaLinearLayout.isVisible = noMedia
                        }

                        is QueryResult.Empty -> Unit
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = requireContext()

        albumsRecyclerView.layoutManager = AlbumThumbnailLayoutManager(context)
        albumsRecyclerView.adapter = albumThumbnailAdapter

        ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
            val insets = windowInsets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )

            albumsRecyclerView.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                leftMargin = insets.left
                rightMargin = insets.right
            }
            albumsRecyclerView.updatePadding(bottom = insets.bottom)

            windowInsets
        }

        permissionsGatedCallback.runAfterPermissionsCheck()
    }
}
