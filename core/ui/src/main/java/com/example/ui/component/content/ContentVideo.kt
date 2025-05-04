package com.example.ui.component.content

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.model.ui.ContentInfo
import com.example.model.ui.MediaItem
import com.example.ui.component.video.VideoPlayer
import com.example.resource.R as ResourceR
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
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
            isMute = isMute
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
