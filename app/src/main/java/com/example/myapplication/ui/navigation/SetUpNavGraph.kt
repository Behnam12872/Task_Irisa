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


@Composable
fun SetUpNavGraph(
    innerPadding: PaddingValues,
    navController: NavHostController,
) {
    NavHost(
        modifier = Modifier.padding(innerPadding),
        navController = navController,
        startDestination = AppScreen.LoginScreen
    ) {
        composable<AppScreen.HomeScreen> {
            HomeScreen(navController)
        }
        composable<AppScreen.LoginScreen> {
            LoginScreen(navController = navController)
        }
        composable<AppScreen.SettingScreen> {
        }
        composable<AppScreen.ProfileScreen> {
        }
        composable<AppScreen.NewsScreen> {

        }
    }
}

