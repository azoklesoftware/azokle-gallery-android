/*
 * SPDX-FileCopyrightText: 2023-2024 Azokle Private Limited
 * SPDX-License-Identifier: Apache-2.0
 */

package org.azokle.gallery.fragments

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.shape.MaterialShapeDrawable
import org.azokle.gallery.R
import org.azokle.gallery.ext.getViewProperty
import org.azokle.gallery.ui.ListItem
import org.azokle.gallery.utils.MediaStoreBuckets

/**
 * A fragment showing a search bar with categories.
 * Use the [LibraryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LibraryFragment : Fragment(R.layout.fragment_library) {
    // Views
    private val appBarLayout by getViewProperty<AppBarLayout>(R.id.appBarLayout)
    private val favoritesAlbumListItem by getViewProperty<ListItem>(R.id.favoritesAlbumListItem)
    private val photosAlbumListItem by getViewProperty<ListItem>(R.id.photosAlbumListItem)
    private val libraryNestedScrollView by getViewProperty<NestedScrollView>(R.id.libraryNestedScrollView)
    private val trashAlbumListItem by getViewProperty<ListItem>(R.id.trashAlbumListItem)
    private val videosAlbumListItem by getViewProperty<ListItem>(R.id.videosAlbumListItem)

    // About views
    private val aboutUsListItem by getViewProperty<ListItem>(R.id.aboutUsListItem)
    private val privacyPolicyListItem by getViewProperty<ListItem>(R.id.privacyPolicyListItem)
    private val companyListItem by getViewProperty<ListItem>(R.id.companyListItem)
    private val licensesListItem by getViewProperty<ListItem>(R.id.licensesListItem)
    private val aboutVersionTextView by getViewProperty<TextView>(R.id.aboutVersionTextView)

    // Fragments
    private val parentNavController by lazy {
        requireParentFragment().requireParentFragment().findNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = requireContext()

        appBarLayout.statusBarForeground = MaterialShapeDrawable.createWithElevationOverlay(context)

        ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
            val insets = windowInsets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )

            libraryNestedScrollView.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                leftMargin = insets.left
                rightMargin = insets.right
            }

            windowInsets
        }

        photosAlbumListItem.setOnClickListener {
            openAlbum(MediaStoreBuckets.MEDIA_STORE_BUCKET_PHOTOS)
        }

        videosAlbumListItem.setOnClickListener {
            openAlbum(MediaStoreBuckets.MEDIA_STORE_BUCKET_VIDEOS)
        }

        favoritesAlbumListItem.setOnClickListener {
            openAlbum(MediaStoreBuckets.MEDIA_STORE_BUCKET_FAVORITES)
        }

        trashAlbumListItem.setOnClickListener {
            openAlbum(MediaStoreBuckets.MEDIA_STORE_BUCKET_TRASH)
        }

        aboutUsListItem.setOnClickListener {
            openUrl("https://azokle.com/company-info")
        }

        privacyPolicyListItem.setOnClickListener {
            openUrl("https://policies.azokle.com/privacy")
        }

        companyListItem.setOnClickListener {
            openUrl("https://azokle.com")
        }

        licensesListItem.setOnClickListener {
            openUrl("https://github.com/azoklesoftware/azokle-gallery-android/blob/main/LICENSES")
        }
        // Set version dynamically
        try {
            val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            aboutVersionTextView.text = "${getString(R.string.app_name)} ${pInfo.versionName}"
        } catch (e: Exception) {
            aboutVersionTextView.text = getString(R.string.app_name)
        }
    }

    private fun openUrl(url: String) {
        val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse(url))
        startActivity(intent)
    }

    private fun openAlbum(mediaStoreBucket: MediaStoreBuckets) {
        parentNavController.navigate(
            R.id.action_mainFragment_to_albumViewerFragment,
            AlbumViewerFragment.createBundle(
                bucketId = mediaStoreBucket.id
            )
        )
    }

    companion object {
        private fun createBundle() = bundleOf()

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment SearchFragment.
         */
        fun newInstance() = LibraryFragment().apply {
            arguments = createBundle()
        }
    }
}
