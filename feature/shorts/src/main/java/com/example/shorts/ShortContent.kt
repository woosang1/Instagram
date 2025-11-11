package com.example.shorts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import com.example.model.ui.ContentInfo
import com.example.model.ui.MediaItem
import com.example.shorts.common.ShortsEvent
import com.example.shorts.common.ShortsState
import com.example.shorts.common.ShortsUiState
import com.example.ui.component.content.ContentVideo
import com.example.ui.component.content.VideoTitle
import com.example.ui.component.IGImage
import com.example.utils.extension.getHeightDisplay
import com.example.utils.extension.pxToDp
import com.example.utils.log.DebugLog
import com.example.resource.R as ResourceR

@Composable
internal fun ShortContent(
    state: ShortsState,
    onEvent: (ShortsEvent) -> Unit
) {
    DebugLog("ShortContent 리컴포지션! ")
    (state.shortsUiState as? ShortsUiState.Content)?.let { uiState ->
        DebugLog("(state.shortsUiState as? ShortsUiState.Content)?.let { uiState ->")
        val contentList = uiState.contentInfoList
        val pagerState = rememberPagerState(pageCount = { contentList.size })
        val currentPage = pagerState.currentPage
        VerticalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
        ) { pageIndex ->
            ShortView(
                index = pageIndex,
                isSelectPage = (currentPage == pageIndex),
                model = contentList[pageIndex],
                onEvent = onEvent
            )
        }
    }
}

@Composable
internal fun ShortView(
    index: Int,
    isSelectPage: Boolean,
    model: ContentInfo,
    onEvent: (ShortsEvent) -> Unit
) {
    val context = LocalContext.current
    // 바텀탭 높이 56
    val shortsHeight = context.getHeightDisplay().pxToDp() - 56
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(shortsHeight.dp)
            .background(LocalColors.current.blue),
        contentAlignment = Alignment.Center
    ) {
        val thumbnails = model.mediaItemList.first()
        if (isSelectPage) {
            when (thumbnails) {
                is MediaItem.Image -> {
                    IGImage(
                        modifier = Modifier
                            .fillMaxSize(),
                        model = thumbnails.imageUrl,
                        contentDescription = "Image",
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(ResourceR.drawable.placeholder)
                    )
                }

                is MediaItem.Video -> {
                    ContentVideo(
                        thumbnailsUrl = thumbnails.thumbnailsUrl,
                        videoUrl = thumbnails.videoUrl,
                        isAutoPlay = true,
                        isMute = thumbnails.isMute,
                        videoTitle = VideoTitle.TITLE,
                        onClickVideoEvent = {
                            onEvent.invoke(ShortsEvent.ClickVideo(id = thumbnails.id))
                        }
                    )
                }
            }

        } else {
            val imageUrl = when (thumbnails) {
                is MediaItem.Image -> thumbnails.imageUrl
                is MediaItem.Video -> thumbnails.thumbnailsUrl
            }
            IGImage(
                modifier = Modifier
                    .fillMaxSize(),
                model = imageUrl,
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(ResourceR.drawable.placeholder)
            )
        }

        ShortOverlayUI(
            modifier = Modifier.align(Alignment.BottomEnd),
            title = model.title,
            description = model.description
        )
    }
}
