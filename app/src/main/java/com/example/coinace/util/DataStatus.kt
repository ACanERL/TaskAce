package com.example.coinace.util



sealed class DataStatus<out T> {
    object Loading : DataStatus<Nothing>()
    data class Success<T>(val data: T) : DataStatus<T>()
    data class Error(val message: String) : DataStatus<Nothing>()
}