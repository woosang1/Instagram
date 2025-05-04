package com.example.main

import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.home.navigation.navigationHome
import com.example.mypage.navigation.navigationMypage
import com.example.navigation.MainRoute
import com.example.search.navigation.navigationSearch
import com.example.shorts.navigation.navigationShorts
import com.example.upload.navigation.navigationUpload
import com.example.videodetail.navigation.navigationVideoDetail

internal class MainNavigator(
    val navController: NavHostController,
) {

    fun navigateHome() {
        if (navController.currentDestination?.route.toString().contains(MainRoute.Home::class.simpleName.toString()).not()) {
            navController.navigationHome()
        }
    }

    fun navigateSearch() {
        if (navController.currentDestination?.route.toString().contains(MainRoute.Search::class.simpleName.toString()).not()) {
            navController.navigationSearch()
        }
    }

    fun navigateUpload() {
        if (navController.currentDestination?.route.toString().contains(MainRoute.Upload::class.simpleName.toString()).not()) {
            navController.navigationUpload()
        }
    }

    fun navigateShorts() {
        if (navController.currentDestination?.route.toString().contains(MainRoute.Shorts::class.simpleName.toString()).not()) {
            navController.navigationShorts()
        }
    }

    fun navigateMyPage() {
        if (navController.currentDestination?.route.toString().contains(MainRoute.MyPage::class.simpleName.toString()).not()) {
            navController.navigationMypage()
        }
    }

    fun navigationVideoDetail() {
        navController.navigationVideoDetail()
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
