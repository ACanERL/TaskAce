package com.example.coinace.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinace.data.model.CoinModel
import com.example.coinace.data.repository.CoinRepository
import com.example.coinace.util.DataStatus

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CoinViewModel @Inject constructor(private  val repository: CoinRepository):ViewModel() {
    private val _coinListState = MutableStateFlow<DataStatus<List<CoinModel>>>(DataStatus.Loading)
    val coinListState: MutableStateFlow<DataStatus<List<CoinModel>>>
        get() = _coinListState

    fun fetchData()=viewModelScope.launch {
        repository.fetchDataCoin()
            .onEach {
                _coinListState.value=it
            }
            .launchIn(viewModelScope)
    }
}