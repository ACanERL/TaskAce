package com.example.coinace.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coinace.data.model.FavoriteModel

@Dao
interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCoinToFavorite(coin: FavoriteModel)

    @Query("DELETE FROM favoriteTable Where id=:favId")
    suspend fun deleteCoinFromFavorite(favId:Int)

    @Query("SELECT * FROM favoriteTable")
    fun getCoinToFavorite():List<FavoriteModel>

    @Query("SELECT title FROM favoriteTable")
    fun getFavoritesTitles():List<String>?

}