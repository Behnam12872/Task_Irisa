package com.example.myapplication.data.model

import com.example.myapplication.R

data class CardInformation(
    val title:String,
    val icon:Int,
    val appScreen: AppScreen
)
val cardInformation= listOf(
    CardInformation("News", R.drawable.ic_coin,AppScreen.NewsScreen),
    CardInformation("News", R.drawable.ic_coin,AppScreen.NewsScreen),
    CardInformation("News", R.drawable.ic_coin,AppScreen.NewsScreen),
    CardInformation("News", R.drawable.ic_coin,AppScreen.NewsScreen),
    CardInformation("News", R.drawable.ic_coin,AppScreen.NewsScreen),
    CardInformation("News", R.drawable.ic_coin,AppScreen.NewsScreen),
)
val cardInformation2= listOf(
    CardInformation("News", R.drawable.ic_coin,AppScreen.NewsScreen),
    CardInformation("News", R.drawable.ic_coin,AppScreen.NewsScreen),
    CardInformation("News", R.drawable.ic_coin,AppScreen.NewsScreen),
    CardInformation("News", R.drawable.ic_coin,AppScreen.NewsScreen),
)