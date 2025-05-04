package com.example.ui.component.content

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ui.component.video.VideoPlayer
import com.example.resource.R as ResourceR
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import com.example.utils.extension.noRippleClickable
import kotlinx.coroutines.delay

@Composable
fun ContentVideo(
    modifier: Modifier = Modifier,
    thumbnailsUrl: String,
    videoUrl: String,
    isAutoPlay: Boolean = true,
    isMute: Boolean = false,
    onClickEvent: () -> Unit,
) {
    var previousIsMute by remember { mutableStateOf(isMute) }
    var showIcon by remember { mutableStateOf(false) }

    LaunchedEffect(isMute) {
        if (previousIsMute != isMute) {
            previousIsMute = isMute
            showIcon = true
            delay(800)
            showIcon = false
        }
    }

    Box(
        modifier = modifier
            .noRippleClickable { onClickEvent() }
    ){
        VideoPlayer(
            thumbnailsUrl = thumbnailsUrl,
            videoUrl = videoUrl,
            isAutoPlay = isAutoPlay,
            isMute = isMute,
            isShowProcessBar = true
        )

        AnimatedVisibility(
            visible = showIcon,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.align(Alignment.Center)
        ) {
            Image(
                modifier = Modifier
                    .size(64.dp)
                    .alpha(0.75f),
                painter = painterResource(
                    id = if (isMute) ResourceR.drawable.mute_on else ResourceR.drawable.mute_off
                ),
                contentDescription = if (isMute) "Muted" else "Unmuted",
            )
        }
    }
}
