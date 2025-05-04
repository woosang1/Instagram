package com.example.videodetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun VideoDetailRoute(
    videoDetailViewModel: VideoDetailViewModel = hiltViewModel()
) {
    VideoDetailScreen()
}