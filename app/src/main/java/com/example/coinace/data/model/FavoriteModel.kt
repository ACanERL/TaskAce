package com.example.coinace.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("favoriteTable")
data class FavoriteModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int,

    @ColumnInfo("image")
    val image:String,

    @ColumnInfo("title")
    val title:String,

    @ColumnInfo("price")
    val price:Double?
)