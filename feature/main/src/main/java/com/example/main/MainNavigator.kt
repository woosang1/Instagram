package com.example.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.home.navigation.navigationHome
import com.example.mypage.navigation.navigationMypage
import com.example.navigation.MainRoute
import com.example.shorts.navigation.navigationShorts
import com.example.subscribe.navigation.navigationSubscribe
import com.example.upload.navigation.navigationUpload

internal class MainNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    fun navigateHome() {
        navController.navigationHome()
    }

    fun navigateShorts() {
        navController.navigationShorts()
    }

    fun navigateUpload() {
        navController.navigationUpload()
    }

    fun navigateSubscribe() {
        navController.navigationSubscribe()
    }

    fun navigateMyPage() {
        navController.navigationMypage()
    }

    fun popBackStackIfNotHome() {
        if (!isSameCurrentDestination<MainRoute.Home>()) {
            popBackStack()
        }
    }

    private fun popBackStack() {
        navController.popBackStack()
    }

    private inline fun <reified T : MainRoute> isSameCurrentDestination(): Boolean {
        return navController.currentDestination?.hasRoute<T>() == true
    }

}

@Composable
internal fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}
