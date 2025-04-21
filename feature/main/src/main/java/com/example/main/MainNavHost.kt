package com.example.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.home.navigation.homeNavGraph
import com.example.mypage.navigation.MypageNavGraph
import com.example.navigation.MainRoute
import com.example.shorts.navigation.ShortsNavGraph
import com.example.subscribe.navigation.SubscribeNavGraph
import com.example.upload.navigation.UploadNavGraph


@Composable
internal fun MainNavHost(
    navigator: MainNavigator,
    modifier: Modifier
) {
    NavHost(
        navController = navigator.navController,
        startDestination = MainRoute.Home,
        modifier = modifier
    ) {
        homeNavGraph()
        ShortsNavGraph()
        UploadNavGraph()
        SubscribeNavGraph()
        MypageNavGraph()
    }
}