package com.example.coinace.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coinace.data.model.FavoriteModel

@Database(entities = [FavoriteModel::class], version = 2, exportSchema = false)
abstract class CoinDatabase:RoomDatabase() {
    abstract fun getCoinDao():CoinDao
}