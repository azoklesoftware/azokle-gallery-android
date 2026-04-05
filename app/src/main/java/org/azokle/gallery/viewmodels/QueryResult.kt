/*
 * SPDX-FileCopyrightText: 2023 Azokle Private Limited
 * SPDX-License-Identifier: Apache-2.0
 */

package org.azokle.gallery.viewmodels

sealed class QueryResult<T> {
    class Empty<T> : QueryResult<T>()
    class Data<T>(val values: List<T>) : QueryResult<T>()
}
