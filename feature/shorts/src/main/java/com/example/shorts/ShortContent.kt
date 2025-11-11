package com.example.shorts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import com.example.model.ui.ContentInfo
import com.example.model.ui.MediaItem
import com.example.shorts.common.ShortsEvent
import com.example.shorts.common.ShortsState
import com.example.shorts.common.ShortsUiState
import com.example.ui.component.IGImage
import com.example.ui.component.content.ContentVideo
import com.example.ui.component.content.VideoTitle
import com.example.resource.R as ResourceR

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ShortContent(
    state: ShortsState,
    onEvent: (ShortsEvent) -> Unit
) {
    val uiState = state.shortsUiState
    if (uiState !is ShortsUiState.Content || uiState.contentInfoList.isEmpty()) {
        return
    }

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { uiState.contentInfoList.size }
    )

    val currentPage by remember { derivedStateOf { pagerState.currentPage } }

    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        key = { index -> uiState.contentInfoList[index].id },
        flingBehavior = PagerDefaults.flingBehavior(state = pagerState)
    ) { page ->
        val item = uiState.contentInfoList[page]
        val isFocused = page == currentPage

        ShortsPagerItem(
            modifier = Modifier.fillMaxSize(),
            item = item,
            isFocused = isFocused,
            onToggleMute = { videoId -> onEvent(ShortsEvent.ClickVideo(id = videoId)) }
        )
    }
}

@Composable
private fun ShortsPagerItem(
    modifier: Modifier,
    item: ContentInfo,
    isFocused: Boolean,
    onToggleMute: (String) -> Unit,
) {
    val firstMedia = remember(item) { item.mediaItemList.firstOrNull() }

    Box(
        modifier = modifier.background(LocalColors.current.black),
        contentAlignment = Alignment.Center
    ) {
        when (val media = firstMedia) {
            is MediaItem.Video -> {
                if (isFocused) {
                    ContentVideo(
                        thumbnailsUrl = media.thumbnailsUrl,
                        videoUrl = media.videoUrl,
                        isAutoPlay = true,
                        isMute = media.isMute,
                        videoTitle = VideoTitle.TITLE,
                        onClickVideoEvent = { onToggleMute(media.id) }
                    )
                } else {
                    IGImage(
                        model = media.thumbnailsUrl,
                        contentDescription = "Short thumbnail",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(ResourceR.drawable.placeholder)
                    )
                }
            }

            is MediaItem.Image -> {
                IGImage(
                    model = media.imageUrl,
                    contentDescription = "Short image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(ResourceR.drawable.placeholder)
                )
            }

            else -> Unit
        }

        ShortOverlayUI(
            modifier = Modifier.align(Alignment.BottomEnd),
            title = item.title,
            description = item.description
        )
    }
}
