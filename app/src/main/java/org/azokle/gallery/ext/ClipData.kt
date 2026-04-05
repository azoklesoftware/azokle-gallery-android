/*
 * SPDX-FileCopyrightText: 2023 Azokle Private Limited
 * SPDX-License-Identifier: Apache-2.0
 */

package org.azokle.gallery.ext

import android.content.ClipData

fun ClipData.asArray() = mutableListOf<ClipData.Item>().apply {
    for (i in 0 until itemCount) {
        this.add(getItemAt(i))
    }
}
