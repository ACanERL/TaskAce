package com.example.coinace.data.repository

import com.example.coinace.data.api.ApiServices
import com.example.coinace.data.model.CoinModel
import com.example.coinace.util.DataStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


import javax.inject.Inject

class CoinRepository @Inject constructor(private val apiServices: ApiServices) {
    fun fetchDataCoin():Flow<DataStatus<List<CoinModel>>> = flow {
        emit(DataStatus.Loading) // Veriler yükleniyor durumunu
        try {
          val response=apiServices.getCoinsMarket()
           if(response.isSuccessful){
               val coinList = response.body()
               emit(DataStatus.Success(coinList ?: emptyList())) // Başarılı durum ve verileri
           }else{
               emit(DataStatus.Error("Failed to fetch data!"))
           }
        }catch (e:Exception){
            emit(DataStatus.Error(e.message ?: "An error occurred!")) // Hata durumu ve hata mesajını
        }
    }

}