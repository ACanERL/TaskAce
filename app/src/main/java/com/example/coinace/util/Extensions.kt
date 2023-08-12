package com.example.coinace.util

import android.content.Context
import android.view.View
import android.widget.Toast
import java.text.DecimalFormat

fun Context.toastMessage(message:String) = Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
fun View.click(function: ()->Unit){
    this.setOnClickListener {
        function()
    }
}

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.gone(){
    visibility = View.GONE
}

private val formatter2= DecimalFormat("##.##")
private val formatter3= DecimalFormat("##.###")
private val formatter4= DecimalFormat("##.####")
fun Double.roundToTwoDecimals() = formatter2.format(this).toString()
fun Double.roundToThreeDecimals() = formatter3.format(this).toString()
fun Double.roudToFourDecimals()= formatter4.format(this).toString()


fun List<Double?>?.toDoubleFloatPairs(): List<Pair<String, Float>> {
    return this!!.map { d ->
        val f = d!!.toFloat()
        val s = d.toString()
        Pair(s, f)
    }
}