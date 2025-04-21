package com.example.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.model.ui.ContentInfo
import com.example.ui.component.content.ContentCard

@Composable
internal fun HomeContent() {
    val listState = rememberLazyListState()

    // 더미 데이터 예시
    val sectionList: List<ContentInfo> = listOf(
        ContentInfo(
            thumbnailUrl = "https://entertainimg.kbsmedia.co.kr/cms/uploads/CONTENTS_20230425095757_b457a570577d7444e7cef5c0a6e73bd7.png",
            channelThumbnailUrl = "https://yt3.ggpht.com/ytc/CHANNEL_ID_1=s68-c-k-c0x00ffffff-no-rj",
            title = "Jetpack Compose 기초 마스터하기",
            channelName = "Compose Korea",
            viewCount = "조회수 12만회",
            timeAgo = "1일 전"
        ),
        ContentInfo(
            thumbnailUrl = "https://entertainimg.kbsmedia.co.kr/cms/uploads/CONTENTS_20230425095757_b457a570577d7444e7cef5c0a6e73bd7.png",
            channelThumbnailUrl = "https://yt3.ggpht.com/ytc/CHANNEL_ID_2=s68-c-k-c0x00ffffff-no-rj",
            title = "Android 개발자가 반드시 알아야 할 팁 10가지",
            channelName = "Dev You",
            viewCount = "조회수 3.4만회",
            timeAgo = "3일 전"
        ),
        ContentInfo(
            thumbnailUrl = "https://entertainimg.kbsmedia.co.kr/cms/uploads/CONTENTS_20230425095757_b457a570577d7444e7cef5c0a6e73bd7.png",
            channelThumbnailUrl = "https://yt3.ggpht.com/ytc/CHANNEL_ID_3=s68-c-k-c0x00ffffff-no-rj",
            title = "Jetpack Compose vs XML, 누가 이길까?",
            channelName = "Android Lab",
            viewCount = "조회수 7.8만회",
            timeAgo = "1주 전"
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        state = listState
    ) {
        items(sectionList) { section ->
            ContentCard(
                contentInfo = section,
                onClick = {
                    // TODO: 클릭 이벤트 처리
                }
            )
        }
    }
}
