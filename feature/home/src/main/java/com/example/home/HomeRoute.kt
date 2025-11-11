package com.example.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.home.common.HomeSideEffect
import com.example.utils.extension.showToast
import com.example.utils.log.DebugLog

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onStartVideoDetail: () -> Unit
) {
    val state by homeViewModel.state.collectAsStateWithLifecycle()
    val sideEffect = homeViewModel.effect
    val context = LocalContext.current

    LaunchedEffect(sideEffect) {
        sideEffect.collect { effect ->
            when(effect){
                is HomeSideEffect.StartVideoDetail -> {
                    DebugLog(" is HomeSideEffect.StartVideoDetail -> ")
                    onStartVideoDetail()
                }
                is HomeSideEffect.ShowToast -> {
                    context.showToast(context.getString(effect.messageResId))
                }
            }
        }
    }

    HomeScreen(
        state = state,
        onEvent = { event -> homeViewModel.setEvent(event) }
    )
}