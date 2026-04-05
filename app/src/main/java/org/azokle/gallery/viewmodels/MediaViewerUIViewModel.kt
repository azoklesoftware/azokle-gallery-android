/*
 * SPDX-FileCopyrightText: 2023 Azokle Private Limited
 * SPDX-License-Identifier: Apache-2.0
 */

package org.azokle.gallery.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import org.azokle.gallery.models.Media
import org.azokle.gallery.recyclerview.MediaViewerAdapter

class MediaViewerUIViewModel(application: Application) : AndroidViewModel(application) {
    /**
     * The current height of top and bottom sheets, used to apply padding to media view UI.
     */
    val sheetsHeightLiveData = MutableLiveData<Pair<Int, Int>>()

    /**
     * Fullscreen mode, set by the user with a single tap on the viewed media.
     */
    val fullscreenModeLiveData = MutableLiveData(false)

    /**
     * The currently displayed media, [MediaViewerAdapter] will take care of updating the value.
     */
    val displayedMedia = MutableLiveData<Media?>(null)

    /**
     * Toggle fullscreen mode.
     */
    fun toggleFullscreenMode() {
        fullscreenModeLiveData.value = when (fullscreenModeLiveData.value) {
            true -> false
            else -> true
        }
    }
}
