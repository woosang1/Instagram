package com.example.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.home.common.HomeEvent
import com.example.home.common.HomeState
import com.example.home.common.HomeUiState
import com.example.ui.component.content.ContentFeed
import com.example.utils.log.DebugLog

@Composable
internal fun HomeContent(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit
) {
    val listState = rememberLazyListState()

// 화면 크기와 중앙 위치 계산 (세로 높이 기준)
    val screenHeightDp = LocalConfiguration.current.screenHeightDp
    val screenCenter = (screenHeightDp / 2).toFloat()

    // LazyColumn에서 화면 중앙에 가까운 아이템을 찾는 함수
    val centerIndex = remember {
        derivedStateOf {
            val visibleItems = listState.layoutInfo.visibleItemsInfo

            // 가장 중앙에 가까운 아이템의 인덱스를 찾기 (세로 위치 기준)
            visibleItems.minByOrNull {
                val itemCenter = it.offset + (it.size / 2)
                kotlin.math.abs(screenCenter - itemCenter)
            }?.index ?: -1 // 해당 인덱스를 반환, 없으면 -1
        }
    }

    (state.homeUiState as? HomeUiState.Content)?.let { uiState ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            state = listState
        ) {
            itemsIndexed(uiState.contentList, key = { index, section -> section.id }) { index, section ->
                ContentFeed(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    isShowingItem = (centerIndex.value == index),
                    contentInfo = section,
                    onProfileClick = {},
                    onLikeClick = {},
                    onCommentClick = {},
                    onShareClick = {},
                    onMuteClick = { contentId, mediaId ->
                        onEvent(HomeEvent.ClickMuteIcon(contentId = contentId, mediaId = mediaId))
                    }
                )
            }
        }
    }

}
