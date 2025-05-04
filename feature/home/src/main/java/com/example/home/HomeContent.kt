package com.example.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.home.common.HomeEvent
import com.example.home.common.HomeState
import com.example.home.common.HomeUiState
import com.example.home.common.Section
import com.example.home.layout.HeaderLayout
import com.example.home.layout.StoryList
import com.example.ui.component.content.ContentFeed

@Composable
internal fun HomeContent(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit
) {
    val listState = rememberLazyListState()

    val density = LocalDensity.current.density
    val screenHeightPx = LocalConfiguration.current.screenHeightDp * density
    val screenCenterPx = screenHeightPx / 2f

    val centerIndex = remember {
        derivedStateOf {
            val visibleItems = listState.layoutInfo.visibleItemsInfo

            visibleItems.minByOrNull {
                val itemCenter = it.offset + (it.size / 2)
                kotlin.math.abs(screenCenterPx - itemCenter)
            }?.index ?: -1
        }
    }

    (state.homeUiState as? HomeUiState.Content)?.let { uiState ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            state = listState
        ) {
            itemsIndexed(uiState.section) { index, section ->
                when(section){
                    is Section.Header -> {
                        HeaderLayout(
                            onClickLike = {},
                            onClickShare = {}
                        )
                    }
                    is Section.Story -> {
                        StoryList(stories = section.storyList)
                    }
                    is Section.Feed -> {
                        ContentFeed(
                            modifier = Modifier
                                .padding(top = 8.dp),
                            isShowingItem = (centerIndex.value == index),
                            contentInfo = section.contentInfo,
                            onProfileClick = {},
                            onLikeClick = {},
                            onCommentClick = {},
                            onShareClick = {},
                            onMuteClick = { contentId, mediaId ->
                                onEvent(HomeEvent.ClickMuteIcon(contentId = contentId, mediaId = mediaId))
                            },
                            onClickVideo = { id ->
                                onEvent(HomeEvent.ClickVideo(videoId = id))
                            }
                        )
                    }
                }
            }
        }
    }

}
