package com.example.tourguide.model

import android.graphics.drawable.Drawable

data class Place(
    val name: String,
    val image: Drawable,
    val address: String,
    val overview: String,
    val time: String
)
