package com.example.shorts.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.shorts.ShortsRoute
import com.example.shorts.api.ShortsDestination

fun NavController.navigationShorts() {
    navigate(ShortsDestination)
}

fun NavGraphBuilder.shortsNavGraph() {
    composable<ShortsDestination> {
        ShortsRoute()
    }
}