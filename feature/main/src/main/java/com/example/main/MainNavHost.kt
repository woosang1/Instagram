package com.example.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.home.navigation.homeNavGraph
import com.example.mypage.navigation.MypageNavGraph
import com.example.navigation.MainRoute
import com.example.search.navigation.SearchNavGraph
import com.example.shorts.navigation.ShortsNavGraph
import com.example.upload.navigation.UploadNavGraph
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
        SearchNavGraph()
        UploadNavGraph()
        ShortsNavGraph()
        MypageNavGraph()
        videoDetailNavGraph(
            onBackEvent = { navigator.popBackStackIfNotHome() }
        )
    }
}