/*
 * SPDX-FileCopyrightText: 2023 Azokle Private Limited
 * SPDX-License-Identifier: Apache-2.0
 */

package org.azokle.gallery.recyclerview

import android.content.Context
import org.azokle.gallery.ext.px

class AlbumThumbnailLayoutManager(
    context: Context,
) : DisplayAwareGridLayoutManager(context, 2, 24.px)
