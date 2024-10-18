package com.example.myapplication.data.model

interface Error

typealias RootError = Error

sealed class DataResult<out D, out E : RootError> {
    data class Success<out D, out E : RootError>(val data: D) : DataResult<D, E>()
    data class Error<out D, out E : RootError>(val error: E) : DataResult<D, E>()
    override fun toString(): String {
        return when (this) {
            is Success -> "Success[data=$data]"
            is Error -> "Error[exception=$error]"
        }
    }
}

sealed class DataError : RootError {
    data object ApiError : DataError()
    data object Unknown : DataError()
}

class ApiException(message: String) : Exception(message)