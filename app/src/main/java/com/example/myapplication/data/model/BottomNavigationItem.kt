package com.example.myapplication.data.model

import com.example.myapplication.R

data class BottomNavigationItem(
    val label: Int,
    val icon: Int,
    val route: AppScreen,
)

val bottomNavigationItems = listOf(
    BottomNavigationItem(
        label = R.string.profile,
        icon = R.drawable.ic_profile,
        route = AppScreen.ProfileScreen
    ),
    BottomNavigationItem(
        label = R.string.home,
        icon = R.drawable.ic_home,
        route = AppScreen.HomeScreen
    ),
    BottomNavigationItem(
        label = R.string.setting,
        icon = R.drawable.ic_setting,
        route = AppScreen.SettingScreen
    )
)