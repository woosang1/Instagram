package com.example.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
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
import kotlin.math.abs
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import com.example.designsystem.theme.LocalColors

private const val LOAD_MORE_THRESHOLD = 4

@Composable
internal fun HomeContent(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit
) {
    val listState = rememberLazyListState()
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val screenCenterPx = remember(configuration, density) {
        with(density) { configuration.screenHeightDp.dp.toPx() / 2f }
    }
    var centeredFeedIndex by remember { mutableIntStateOf(-1) }

    (state.homeUiState as? HomeUiState.Content)?.let { uiState ->
        val sections = uiState.section

        LaunchedEffect(listState, sections, screenCenterPx) {
            snapshotFlow { listState.layoutInfo.visibleItemsInfo }
                .map { visibleItems ->
                    visibleItems
                        .mapNotNull { info ->
                            val section = sections.getOrNull(info.index)
                            if (section is Section.Feed) {
                                val itemCenter = info.offset + (info.size / 2)
                                info.index to abs(screenCenterPx - itemCenter)
                            } else {
                                null
                            }
                        }
                        .minByOrNull { it.second }
                        ?.first ?: -1
                }
                .filter { it >= 0 }
                .distinctUntilChanged()
                .collect { centeredFeedIndex = it }
        }

        LaunchedEffect(listState, sections.size, uiState.isAppending, uiState.hasMore) {
            if (!uiState.hasMore) return@LaunchedEffect
            snapshotFlow {
                val layoutInfo = listState.layoutInfo
                val totalItems = layoutInfo.totalItemsCount
                val lastVisible = layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: -1
                totalItems to lastVisible
            }
                .filter { (total, last) -> total > 0 && last >= 0 }
                .map { (total, last) -> total - last <= LOAD_MORE_THRESHOLD }
                .distinctUntilChanged()
                .filter { it && !uiState.isAppending }
                .collect { onEvent(HomeEvent.LoadNextPage) }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            state = listState,
            contentPadding = PaddingValues(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(
                items = sections,
                key = { _, section ->
                    when (section) {
                        Section.Header -> "header"
                        is Section.Story -> "story-${section.storyList.hashCode()}"
                        is Section.Feed -> "feed-${section.contentInfo.id}"
                    }
                },
                contentType = { _, section ->
                    when (section) {
                        Section.Header -> "header"
                        is Section.Story -> "story"
                        is Section.Feed -> "feed"
                    }
                }
            ) { index, section ->
                when (section) {
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
                            isShowingItem = (centeredFeedIndex == index),
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
            if (uiState.isAppending) {
                item(key = "paging-loader", contentType = "loader") {
                    PagingLoadingIndicator()
                }
            }
        }
    }

}

@Composable
private fun PagingLoadingIndicator(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .padding(8.dp),
            color = LocalColors.current.white,
            strokeWidth = 2.dp
        )
    }
}

