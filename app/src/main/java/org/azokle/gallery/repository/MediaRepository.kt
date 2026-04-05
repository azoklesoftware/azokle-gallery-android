/*
 * SPDX-FileCopyrightText: 2023 Azokle Private Limited
 * SPDX-License-Identifier: Apache-2.0
 */

package org.azokle.gallery.repository

import android.content.Context
import org.azokle.gallery.flow.AlbumFlow
import org.azokle.gallery.flow.AlbumsFlow
import org.azokle.gallery.flow.MediaFlow

@Suppress("Unused")
object MediaRepository {
    fun media(
        context: Context,
        bucketId: Int,
        mimeType: String? = null,
    ) = MediaFlow(context, bucketId, mimeType).flowData()

    fun mediaCursor(
        context: Context,
        bucketId: Int,
        mimeType: String? = null,
    ) = MediaFlow(context, bucketId, mimeType).flowCursor()

    fun album(
        context: Context,
        bucketId: Int,
        mimeType: String? = null,
    ) = AlbumFlow(context, bucketId, mimeType).flowData()

    fun albumCursor(
        context: Context,
        bucketId: Int,
        mimeType: String? = null,
    ) = AlbumFlow(context, bucketId, mimeType).flowCursor()

    fun albums(
        context: Context,
        mimeType: String? = null,
    ) = AlbumsFlow(context, mimeType).flowData()

    fun albumsCursor(
        context: Context,
        mimeType: String? = null,
    ) = AlbumsFlow(context, mimeType).flowCursor()
}
