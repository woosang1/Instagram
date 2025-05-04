package com.example.videodetail.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.MainRoute
import com.example.utils.log.DebugLog
import com.example.videodetail.VideoDetailRoute

fun NavController.navigationVideoDetail(){
    DebugLog(" NavController.navigationVideoDetail!!!!")
    navigate(route = MainRoute.VideoDetail)

}

fun NavGraphBuilder.videoDetailNavGraph() {
    DebugLog(" videoDetailNavGraph !!! ")
    composable<MainRoute.VideoDetail>(
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },  // 화면이 왼쪽에서 오른쪽으로 슬라이드
                animationSpec = tween(500)
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it },  // 화면이 왼쪽으로 나가도록 설정
                animationSpec = tween(500)
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it },  // 뒤로 가기 시 왼쪽에서 오른쪽으로 슬라이드
                animationSpec = tween(500)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },  // 뒤로 가기 시 오른쪽으로 나가도록 설정
                animationSpec = tween(500)
            )
        }
    ) {
        VideoDetailRoute()
    }
}