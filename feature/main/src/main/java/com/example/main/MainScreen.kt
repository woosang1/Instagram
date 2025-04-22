package com.example.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.toRoute
import com.example.designsystem.theme.LocalColors
import com.example.navigation.MainRoute

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
                        is MainRoute.Search -> mainNavigator.navigateSearch()
                        is MainRoute.Upload -> mainNavigator.navigateUpload()
                        is MainRoute.Shorts -> mainNavigator.navigateShorts()
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
    NavigationBar(
        containerColor = LocalColors.current.black,
        contentColor = LocalColors.current.white
    ) {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { onTabSelected(item.route) },
                icon = {
                    Image(
                        painter = painterResource(id = item.iconResId),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize().padding(4.dp)
                    )
                }
            )
        }
    }
}
