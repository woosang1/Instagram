package com.example.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.home.HomeRoute
import com.example.home.api.HomeDestination

fun NavController.navigationHome() {
    navigate(HomeDestination)
}

fun NavGraphBuilder.homeNavGraph(
    onStartVideoDetail: () -> Unit
) {
    composable<HomeDestination> {
        HomeRoute(
            onStartVideoDetail = onStartVideoDetail
        )
    }
}