package com.example.shorts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ShortsRoute(
    shortsViewModel: ShortsViewModel = hiltViewModel()
) {
    val state by shortsViewModel.state.collectAsStateWithLifecycle()

    ShortsScreen(
        state = state,
        onEvent = { event -> shortsViewModel.setEvent(event) }
    )
}