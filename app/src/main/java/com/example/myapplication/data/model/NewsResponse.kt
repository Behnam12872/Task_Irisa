package com.example.myapplication.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val Type: Int,
    val Message: String,
    val Promoted: List<String>,
    val Data: List<NewsItem>,
    val RateLimit: RateLimit?,
    val HasWarning: Boolean
)

@Serializable
data class NewsItem(
    val id: String,
    val guid: String,
    val published_on: Long,
    val imageurl: String,
    val title: String,
    val url: String,
    val body: String,
    val tags: String,
    val lang: String,
    val upvotes: String,
    val downvotes: String,
    val categories: String,
    val source_info: SourceInfo,
    val source: String
)

@Serializable
data class SourceInfo(
    val name: String,
    val img: String,
    val lang: String
)

@Serializable
class RateLimit
