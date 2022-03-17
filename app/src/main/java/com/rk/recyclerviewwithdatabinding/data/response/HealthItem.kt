package com.rk.recyclerviewwithdatabinding.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HealthItem  (
    val name: String,
    val height: String,
    val mass: String,
    val hair_color: String,
    val skin_color: String,
    val eye_color: String,
    val birth_year: String,
    val gender: String,
    val image: String


): Parcelable

