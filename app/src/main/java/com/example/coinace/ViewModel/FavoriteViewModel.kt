package com.example.coinace.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinace.data.model.CoinModel
import com.example.coinace.data.model.FavoriteModel
import com.example.coinace.data.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: FavoriteRepository):ViewModel() {
    private var _coins:MutableLiveData<CoinModel> = MutableLiveData()
    val coinmodel=_coins

    fun addToFavorite()=viewModelScope.launch {
        _coins.value.let {
            if(it!=null){
                repository.addProductToFavorite(
                    FavoriteModel(id =it.id.toInt(), image = it.image, title = it.name, price = it.current_price)
                )
            }
        }
    }
}