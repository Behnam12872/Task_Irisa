package com.example.myapplication.data.repository


import com.example.myapplication.data.model.ApiException
import com.example.myapplication.data.model.DataError
import com.example.myapplication.data.model.DataResult
import com.example.myapplication.data.model.NewsResponse
import com.example.myapplication.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

private val apiService = ApiService.create()

class NewsRepositoryImpl : NewsRepository {
    override suspend fun getNews(): Flow<DataResult<NewsResponse, DataError>> = flow {
        apiService.getNews().catch { e ->
            val error = when (e) {
                is ApiException -> DataError.ApiError
                else -> DataError.Unknown
            }
            emit(DataResult.Error(error))
        }.collect { news ->
            emit(DataResult.Success(news))
        }
    }
}