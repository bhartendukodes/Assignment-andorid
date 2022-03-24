package com.example.androidassignment.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageItem(
    val author: String,
    val download_url: String,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
):Parcelable