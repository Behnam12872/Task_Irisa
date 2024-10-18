package com.example.myapplication.data.model

import kotlinx.serialization.Serializable

@Serializable
sealed class AppScreen {

    @Serializable
    data object HomeScreen : AppScreen()

    @Serializable
    data object NewsScreen : AppScreen()

    @Serializable
    data object LoginScreen : AppScreen()

    @Serializable
    data object ProfileScreen : AppScreen()

    @Serializable
    data object SettingScreen : AppScreen()
}