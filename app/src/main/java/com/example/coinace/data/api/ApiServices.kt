package com.example.coinace.data.api

import com.example.coinace.data.model.CoinModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("coins/markets?vs_currency=usd&per_page=50&page=1&sparkline=true")
    suspend fun getCoinsMarket() : Response<List<CoinModel>>

    @GET("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=2&page=1&sparkline=true&price_change_percentage=30")
    suspend fun get30DayData():Response<List<CoinModel>>
}