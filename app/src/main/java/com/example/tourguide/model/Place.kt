package com.example.tourguide.model

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Place(
    val name: String,
    val imageId: Int,
    val address: String,
    val overview: String,
    val time: String
): Parcelable
