package com.example.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.toRoute
import com.example.navigation.MainRoute
import com.example.utils.log.DebugLog

@Composable
fun MainScreen() {
    val mainNavigator = rememberMainNavigator()
    val navController = mainNavigator.navController
    val currentBackStackEntry = navController.currentBackStackEntryAsState().value
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentRoute = currentBackStackEntry?.toRoute() ?: MainRoute.Home,
                onTabSelected = { route ->
                    when (route) {
                        is MainRoute.Home -> mainNavigator.navigateHome()
                        is MainRoute.Shorts -> mainNavigator.navigateShorts()
                        is MainRoute.Upload -> mainNavigator.navigateUpload()
                        is MainRoute.Subscribe -> mainNavigator.navigateSubscribe()
                        is MainRoute.MyPage -> mainNavigator.navigateMyPage()
                    }
                }
            )
        }
    ) { innerPadding ->
        MainNavHost(
            navigator = mainNavigator,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun BottomNavigationBar(
    currentRoute: MainRoute,
    onTabSelected: (MainRoute) -> Unit
) {
    NavigationBar {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute::class == item.route::class,
                onClick = { onTabSelected(item.route) },
                icon = {},
                label = { Text(item.label) },
                alwaysShowLabel = true
            )
        }
    }
}
