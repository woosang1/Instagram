package com.example.subscribe.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.MainRoute
import com.example.subscribe.SubscribeRoute

fun NavController.navigationSubscribe(){
    navigate(MainRoute.Subscribe)
}

fun NavGraphBuilder.SubscribeNavGraph() {
    composable<MainRoute.Subscribe>{
        SubscribeRoute()
    }
}