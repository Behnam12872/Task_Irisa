package com.example.myapplication.data.remote

import com.example.myapplication.data.model.NewsResponse
import com.example.myapplication.util.API_KEY
import com.example.myapplication.util.API_TOKEN
import com.example.myapplication.util.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.headers
import io.ktor.http.isSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiServiceImpl(private val client: HttpClient) : ApiService {
    override suspend fun getNews(): Flow<NewsResponse> = flow {
        try {
            val response: HttpResponse = client.get(BASE_URL) {
                headers {
                    append(API_KEY, API_TOKEN)
                }
            }
            if (response.status.isSuccess()){
                emit(response.body())
            }else{
                throw Exception("Failed to Get News")
            }
        } catch (e: Exception) {
            throw e
        }
    }
}