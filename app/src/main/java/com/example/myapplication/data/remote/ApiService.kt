package com.example.myapplication.data.remote

import com.example.myapplication.data.model.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

interface ApiService {
    suspend fun getNews(): Flow<NewsResponse>

    companion object {
        fun create(): ApiServiceImpl {
            return ApiServiceImpl(
                client = createClient()
            )
        }
        @OptIn(ExperimentalSerializationApi::class)
        fun createClient(): HttpClient {
            val client = HttpClient(CIO) {
                install(Logging) {
                    logger = Logger.DEFAULT
                    level = LogLevel.ALL
                }
                install(ContentNegotiation) {
                    json(Json {
                        ignoreUnknownKeys = true
                        prettyPrint = true
                        isLenient = true
                        explicitNulls = false
                    })
                }
                install(HttpTimeout) {
                    requestTimeoutMillis = 15000L
                    connectTimeoutMillis = 15000L
                    socketTimeoutMillis = 15000L
                }
                install(HttpSend) {
                    maxSendCount = 3
                }
            }
            return client
        }
    }
}