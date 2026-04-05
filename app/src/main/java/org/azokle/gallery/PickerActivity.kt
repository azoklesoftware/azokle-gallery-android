/*
 * SPDX-FileCopyrightText: 2024 Azokle Private Limited
 * SPDX-License-Identifier: Apache-2.0
 */

package org.azokle.gallery

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.shape.MaterialShapeDrawable
import org.azokle.gallery.models.MediaType
import org.azokle.gallery.utils.PickerUtils

class PickerActivity : AppCompatActivity(R.layout.activity_picker) {
    // Views
    private val appBarLayout by lazy { findViewById<AppBarLayout>(R.id.appBarLayout)!! }
    private val contentView by lazy { findViewById<View>(android.R.id.content)!! }
    private val toolbar by lazy { findViewById<MaterialToolbar>(R.id.toolbar)!! }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)

        appBarLayout.statusBarForeground = MaterialShapeDrawable.createWithElevationOverlay(this)

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        ViewCompat.setOnApplyWindowInsetsListener(contentView) { _, windowInsets ->
            val insets = windowInsets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )

            toolbar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                leftMargin = insets.left
                rightMargin = insets.right
            }

            windowInsets
        }

        // Parse intent
        if (intent.action !in org.azokle.gallery.PickerActivity.Companion.supportedIntentActions) {
            Toast.makeText(
                this, R.string.intent_action_not_supported, Toast.LENGTH_SHORT
            ).show()
            finish()
            return
        }

        val mimeType = PickerUtils.translateMimeType(intent) ?: run {
            Toast.makeText(
                this, R.string.intent_media_type_not_supported, Toast.LENGTH_SHORT
            ).show()
            finish()
            return
        }

        val mediaType = MediaType.fromMimeType(mimeType)

        toolbar.setTitle(
            when (mediaType) {
                MediaType.IMAGE -> R.string.pick_a_photo
                MediaType.VIDEO -> R.string.pick_a_video
                else -> R.string.pick_a_media
            }
        )
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            onBackPressedDispatcher.onBackPressed()
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    companion object {
        private val supportedIntentActions = listOf(
            Intent.ACTION_GET_CONTENT,
            Intent.ACTION_PICK,
            Intent.ACTION_SET_WALLPAPER,
        )
    }
}
