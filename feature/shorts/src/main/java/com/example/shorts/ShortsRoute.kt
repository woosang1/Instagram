package com.example.shorts

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ShortsRoute(
    shortsViewModel: ShortsViewModel = hiltViewModel()
) {
    ShortsScreen()
}