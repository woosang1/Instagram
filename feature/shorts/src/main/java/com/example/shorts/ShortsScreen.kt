package com.example.shorts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.designsystem.theme.LocalColors
import com.example.shorts.common.ShortsEvent
import com.example.shorts.common.ShortsState

@Composable
fun ShortsScreen(
    state: ShortsState,
    onEvent: (ShortsEvent) -> Unit
) {
    LaunchedEffect(Unit) {
        onEvent(ShortsEvent.Init)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.gray)
    ) {
        ShortContent(
            state = state,
            onEvent = onEvent
        )
    }
}