package com.example.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.home.navigation.homeNavGraph
import com.example.mypage.navigation.mypageNavGraph
import com.example.navigation.MainRoute
import com.example.search.navigation.searchNavGraph
import com.example.shorts.navigation.shortsNavGraph
import com.example.upload.navigation.uploadNavGraph
import com.example.videodetail.navigation.videoDetailNavGraph


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
        homeNavGraph(
            onStartVideoDetail = { navigator.navigationVideoDetail() }
        )
        searchNavGraph(
            onStartVideoDetail = { navigator.navigationVideoDetail() }
        )
        uploadNavGraph()
        shortsNavGraph()
        mypageNavGraph()
        videoDetailNavGraph(
            onBackEvent = { navigator.popBackStackIfNotHome() }
        )
    }
}