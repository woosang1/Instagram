package com.example.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.home.common.HomeSideEffect
import com.example.utils.log.DebugLog

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onStartVideoDetail: () -> Unit
) {
    val state by homeViewModel.state.collectAsStateWithLifecycle()
    val sideEffect = homeViewModel.effect
    val navController = rememberNavController()

//    // 네비게이션 처리
//    NavHost(
//        navController = navController,
//        startDestination = ScreenRoute.Home
//    ) {
//        composable<ScreenRoute.Home>{}
//        videoDetailNavGraph()
//    }
//
    LaunchedEffect(sideEffect) {
        sideEffect.collect { effect ->
            when(effect){
                is HomeSideEffect.StartVideoDetail -> {
                    DebugLog(" is HomeSideEffect.StartVideoDetail -> ")
                    onStartVideoDetail()
                }
            }
        }
    }

    HomeScreen(
        state = state,
        onEvent = { event -> homeViewModel.setEvent(event) }
    )
}