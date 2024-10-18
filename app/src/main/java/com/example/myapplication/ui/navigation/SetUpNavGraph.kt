package ir.example.taskirisa.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.data.model.AppScreen


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
        }
        composable<AppScreen.LoginScreen> {
        }
        composable<AppScreen.SettingScreen> {
        }
        composable<AppScreen.ProfileScreen> {
        }
        composable<AppScreen.NewsScreen> {

        }
    }
}

