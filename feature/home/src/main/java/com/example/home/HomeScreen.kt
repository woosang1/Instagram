package com.example.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.designsystem.theme.LocalColors
import com.example.home.common.HomeEvent
import com.example.home.common.HomeState
import com.example.utils.log.DebugLog

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit
) {
    LaunchedEffect(Unit) {
        onEvent(HomeEvent.Init)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.black)
    ) {
        HomeContent(
            state = state,
            onEvent = onEvent
        )
    }
}