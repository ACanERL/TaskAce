package com.example.coinace.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SparkLine(
    @SerializedName("price")
    val price: List<Double?>?
) : Parcelable
