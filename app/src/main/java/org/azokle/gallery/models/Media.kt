/*
 * SPDX-FileCopyrightText: 2023 Azokle Private Limited
 * SPDX-License-Identifier: Apache-2.0
 */

package org.azokle.gallery.models

import android.net.Uri

/**
 * A generic media representation.
 */
interface Media {
    val uri: Uri
    val mediaType: MediaType
    val mimeType: String
}
