package com.example.videodetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.designsystem.theme.LocalColors

@Composable
fun VideoDetailScreen(

) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.black)
    ) {
        VideoDetailContent()
    }
}