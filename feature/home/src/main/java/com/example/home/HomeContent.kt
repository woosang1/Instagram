package com.example.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.model.ui.ContentInfo
import com.example.ui.component.content.ContentFeed

@Composable
internal fun HomeContent() {
    val listState = rememberLazyListState()

    // 더미 데이터 예시
    val testContentList = listOf(
        ContentInfo(
            thumbnailUrls = listOf(
                "https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg",
                "https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-다섯-번째-미니앨범-Whiplash-티저-이미지-4.jpg",
                "https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg"
            ),
            channelThumbnailUrl = "https://www.smentertainment.com/newsroom/%EC%B9%B4%EB%A6%AC%EB%82%98-%EC%86%94%EB%A1%9C%EA%B3%A1-up-%EB%A9%9C%EB%A1%A0-%EC%9D%BC%EA%B0%84-1%EC%9C%84-supernova-%EC%9D%B4%ED%9B%84-40%EC%9D%BC-%EB%A7%8C/",
            title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
            channelName = "Karina Official",
            viewCount = "1.5M",
            timeAgo = "2시간 전"
        ),
        ContentInfo(
            thumbnailUrls = listOf(
                "https://www.koreadaily.com/data/photo/2025/04/04/202504040956775461_67ef328b2feae.jpg",
                "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY"
            ),
            channelThumbnailUrl = "https://iuedelweiss.tistory.com/258",
            title = "아이유의 생일 기념 고화질 화보 모음",
            channelName = "IU Official",
            viewCount = "2.3M",
            timeAgo = "5시간 전"
        ),
        ContentInfo(
            thumbnailUrls = listOf(
                "https://www.mk.co.kr/news/photos/11271822",
                "https://secretfantasy.tistory.com/216",
                "https://hdgallery.tistory.com/553"
            ),
            channelThumbnailUrl = "https://www.mk.co.kr/news/photos/11271822",
            title = "아이린의 봄 분위기 물씬 나는 스타일링",
            channelName = "Irene Channel",
            viewCount = "1.1M",
            timeAgo = "1일 전"
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        state = listState
    ) {
        items(testContentList) { section ->
            ContentFeed(
                modifier = Modifier
                    .padding(top = 8.dp),
                contentInfo = section,
                onProfileClick = {},
                onLikeClick = {},
                onCommentClick = {},
                onShareClick = {}
            )
        }
    }
}
