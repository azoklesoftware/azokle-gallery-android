/*
 * SPDX-FileCopyrightText: 2023 Azokle Private Limited
 * SPDX-License-Identifier: Apache-2.0
 */

package org.azokle.gallery.recyclerview

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import org.azokle.gallery.models.MediaStoreMedia
import kotlin.reflect.safeCast

class ThumbnailItemDetailsLookup(
    private val recyclerView: RecyclerView,
) : ItemDetailsLookup<MediaStoreMedia>() {
    override fun getItemDetails(e: MotionEvent) =
        recyclerView.findChildViewUnder(e.x, e.y)?.let { childView ->
            recyclerView.getChildViewHolder(childView)?.let { viewHolder ->
                ThumbnailAdapter.ThumbnailViewHolder::class.safeCast(viewHolder)?.itemDetails
            }
        }
}
