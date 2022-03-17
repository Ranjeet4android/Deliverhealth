package com.rk.recyclerviewwithdatabinding.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results (
    @SerializedName("results")
    val genre: List<HealthItem>
): Parcelable