package com.example.myapplication.data.model

sealed class ViewResult<out T> {
    data class Success<out T>(val data: T) : ViewResult<T>()
    data class Error(val exception: DataError) : ViewResult<Nothing>()
    data object Loading : ViewResult<Nothing>()
}