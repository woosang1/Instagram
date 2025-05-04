package com.example.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.home.HomeRoute
import com.example.navigation.MainRoute

fun NavController.navigationHome(){
    navigate(MainRoute.Home)
}

fun NavGraphBuilder.homeNavGraph(
    onStartVideoDetail: () -> Unit
) {
    composable<MainRoute.Home>{
        HomeRoute(
            onStartVideoDetail = onStartVideoDetail
        )
    }
}