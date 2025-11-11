package com.example.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.home.api.HomeDestination
import com.example.home.navigation.navigationHome
import com.example.mypage.api.MyPageDestination
import com.example.mypage.navigation.navigationMypage
import com.example.search.api.SearchDestination
import com.example.search.navigation.navigationSearch
import com.example.shorts.api.ShortsDestination
import com.example.shorts.navigation.navigationShorts
import com.example.upload.api.UploadDestination
import com.example.upload.navigation.navigationUpload
import com.example.videodetail.api.VideoDetailDestination
import com.example.videodetail.navigation.navigationVideoDetail
import com.example.navigation.MainRoute

internal class MainNavigator(
    val navController: NavHostController,
) {

    fun navigateHome() {
        if (navController.currentDestination?.route.toString().contains(HomeDestination::class.simpleName.toString()).not()) {
            navController.navigationHome()
        }
    }

    fun navigateSearch() {
        if (navController.currentDestination?.route.toString().contains(SearchDestination::class.simpleName.toString()).not()) {
            navController.navigationSearch()
        }
    }

    fun navigateUpload() {
        if (navController.currentDestination?.route.toString().contains(UploadDestination::class.simpleName.toString()).not()) {
            navController.navigationUpload()
        }
    }

    fun navigateShorts() {
        if (navController.currentDestination?.route.toString().contains(ShortsDestination::class.simpleName.toString()).not()) {
            navController.navigationShorts()
        }
    }

    fun navigateMyPage() {
        if (navController.currentDestination?.route.toString().contains(MyPageDestination::class.simpleName.toString()).not()) {
            navController.navigationMypage()
        }
    }

    fun navigationVideoDetail() {
        navController.navigationVideoDetail()
    }

    fun popBackStackIfNotHome() {
        if (!isSameCurrentDestination<HomeDestination>()) {
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
