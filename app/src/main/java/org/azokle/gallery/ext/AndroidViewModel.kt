/*
 * SPDX-FileCopyrightText: 2023 Azokle Private Limited
 * SPDX-License-Identifier: Apache-2.0
 */

package org.azokle.gallery.ext

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

val AndroidViewModel.context: Context
    get() = getApplication<Application>().applicationContext
