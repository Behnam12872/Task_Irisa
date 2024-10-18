package ir.example.taskirisa.ui.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.data.model.bottomNavigationItems
import com.example.myapplication.ui.theme.Pink40

@Composable
fun BottomNavigation(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            bottomNavigationItems.forEach { bottomNavItem ->
                if (currentRoute?.substringBefore("/") == bottomNavItem.route::class.qualifiedName)
                    BottomNavBar(navController = navController)
            }
        }
    ) { innerPadding ->
        SetUpNavGraph(innerPadding, navController = navController)
    }
}

@Composable
fun BottomNavBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier.height(65.dp),
        containerColor = Color.DarkGray,
    ) {
        bottomNavigationItems.forEach { bottomNavItem ->
            val isSelected =
                currentDestination?.hierarchy?.any { it.route?.substringBefore("/") == bottomNavItem.route::class.qualifiedName } == true

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navController.navigate(bottomNavItem.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = bottomNavItem.icon),
                        contentDescription = null,
                    )
                },
                label = {
                    Text(
                        stringResource(id = bottomNavItem.label),
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.LightGray,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.LightGray,
                    indicatorColor = Pink40
                )
            )
        }
    }
}


