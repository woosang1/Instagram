package com.example.shorts.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.MainRoute
import com.example.shorts.ShortsRoute

fun NavController.navigationShorts(){
    navigate(MainRoute.Shorts)
}

fun NavGraphBuilder.shortsNavGraph() {
    composable<MainRoute.Shorts>{
        ShortsRoute()
    }
}