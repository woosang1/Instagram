package com.example.ui.component.content

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.ui.component.video.VideoPlayer
import com.example.utils.extension.noRippleClickable
import kotlinx.coroutines.delay
import com.example.resource.R as ResourceR

@Composable
fun ContentVideo(
    modifier: Modifier = Modifier,
    thumbnailsUrl: String,
    videoUrl: String,
    isAutoPlay: Boolean = true,
    isMute: Boolean = false,
    videoTitle: VideoTitle = VideoTitle.NONE,
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

        when(videoTitle){
            VideoTitle.BACK_ICON -> {
                HeaderLayoutWithBackIcon(
                    modifier = Modifier.align(Alignment.TopCenter),
                    onClickBackIcon = {}
                )
            }
            VideoTitle.TITLE -> {
                HeaderLayoutWithTitle(
                    modifier = Modifier.align(Alignment.TopCenter),
                )
            }
            VideoTitle.NONE -> Unit
        }

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

@Composable
fun HeaderLayoutWithBackIcon(
    modifier: Modifier,
    onClickBackIcon: () -> Unit
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        IconButton(onClick = onClickBackIcon) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Like",
                tint = LocalColors.current.white
            )
        }

        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = "릴스",
            color = LocalColors.current.white,
            style = LocalTypography.current.headline2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
fun HeaderLayoutWithTitle(
    modifier: Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = "릴스",
            color = LocalColors.current.white,
            style = LocalTypography.current.headline2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}