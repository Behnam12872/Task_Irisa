package ir.example.taskirisa.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.data.model.AppScreen
import com.example.myapplication.ui.screen.HomeScreen
import com.example.myapplication.ui.screen.LoginScreen
import com.example.myapplication.ui.screen.ProfileScreen
import com.example.myapplication.ui.screen.SettingScreen
import com.example.myapplication.ui.screen.news.NewsScreen


@Composable
fun SetUpNavGraph(
    innerPadding: PaddingValues,
    navController: NavHostController,
) {
    NavHost(
        modifier = Modifier.padding(innerPadding),
        navController = navController,
        startDestination = AppScreen.HomeScreen
    ) {
        composable<AppScreen.HomeScreen> {
            HomeScreen(navController)
        }
        composable<AppScreen.LoginScreen> {
            LoginScreen(navController = navController)
        }
        composable<AppScreen.SettingScreen> {
            SettingScreen()
        }
        composable<AppScreen.ProfileScreen> {
            ProfileScreen()
        }
        composable<AppScreen.NewsScreen> {
            NewsScreen()
        }
    }
}

