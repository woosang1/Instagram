package com.example.videodetail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun VideoDetailRoute(
    videoDetailViewModel: VideoDetailViewModel = hiltViewModel(),
    onBackEvent: () -> Unit
) {
    VideoDetailScreen(
        onBackEvent = onBackEvent
    )
}