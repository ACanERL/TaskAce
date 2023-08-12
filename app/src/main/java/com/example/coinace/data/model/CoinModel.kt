package com.example.coinace.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CoinModel(
var id:String,
var symbol:String,
var name:String,
var image:String,
var current_price:Double,
var total_volume:Double,
var double: Double,
var marketcaprank:Int,
var high_24h:Double,
var low_24h:Double,
var price_change_24h:Double,
var price_change_percentage_24h:Double,
var price_change_percentage_1h_in_currency:Double,
@SerializedName("sparkline_in_7d")
val sparklineIn7d: SparkLine?,
val price_change_percentage_30d_in_currency:Double
): Parcelable
