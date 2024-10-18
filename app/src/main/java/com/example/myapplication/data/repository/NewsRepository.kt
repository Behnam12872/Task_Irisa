package com.example.myapplication.data.repository

import com.example.myapplication.data.model.DataError
import com.example.myapplication.data.model.DataResult
import com.example.myapplication.data.model.NewsResponse
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews(): Flow<DataResult<NewsResponse, DataError>>
}