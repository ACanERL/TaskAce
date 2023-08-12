package com.example.coinace.data.repository

import com.example.coinace.data.local.CoinDao
import com.example.coinace.data.model.FavoriteModel
import javax.inject.Inject

class FavoriteRepository @Inject constructor(private val db:CoinDao) {
    suspend fun addProductToFavorite(coin: FavoriteModel) {
        db.addCoinToFavorite(coin)
    }

    suspend fun deleteProductFromFavorite(favId:Int){
        db.deleteCoinFromFavorite(favId)
    }

    fun getProductToFavorite():List<FavoriteModel> {
        return db.getCoinToFavorite()
    }
}