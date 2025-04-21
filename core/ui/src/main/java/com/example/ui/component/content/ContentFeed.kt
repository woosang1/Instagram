package com.example.ui.component.content

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.model.ui.ContentInfo
import com.example.model.ui.MediaItem
import com.example.ui.component.video.VideoPlayer
import kotlin.math.abs

@Composable
fun ContentFeed(
    modifier: Modifier = Modifier,
    contentInfo: ContentInfo,
    onProfileClick: () -> Unit,
    onLikeClick: () -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(LocalColors.current.black)
    ) {
        // 상단 프로필 바
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .border(
                        width = 2.dp,
                        color = LocalColors.current.lightGray,
                        shape = CircleShape
                    )
                    .padding(2.dp)
                    .clickable { onProfileClick() }
            ) {
                AsyncImage(
                    model = contentInfo.channelThumbnailUrl,
                    contentDescription = "Channel Thumbnail",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            //  채널 이름
            Text(
                text = contentInfo.channelName,
                color = LocalColors.current.white,
                style = LocalTypography.current.body1,
                modifier = Modifier.weight(1f)
            )

            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More",
                    tint = LocalColors.current.gray
                )
            }
        }

        MediaHorizontalList(mediaItems = contentInfo.thumbnails)

        // 아이콘 바 (좋아요, 댓글, 공유)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onLikeClick) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Like",
                    tint = LocalColors.current.white
                )
            }
            IconButton(onClick = onCommentClick) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Comment",
                    tint = LocalColors.current.white
                )
            }
            IconButton(onClick = onShareClick) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Share",
                    tint = LocalColors.current.white
                )
            }
        }

        // 좋아요 수
        Text(
            text = "${contentInfo.viewCount} likes",
            color = LocalColors.current.white,
            style = LocalTypography.current.body1,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        // 타이틀 + 설명
        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = contentInfo.title,
            color = LocalColors.current.white,
            style = LocalTypography.current.body1,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun MediaHorizontalList(mediaItems: List<MediaItem>) {
    val listState = rememberLazyListState()

    // 가장 중앙에 가까운 아이템 인덱스를 찾기
    val centeredIndex by remember {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val viewportCenter = layoutInfo.viewportEndOffset / 2

            layoutInfo.visibleItemsInfo.minByOrNull { item ->
                val itemCenter = item.offset + item.size / 2
                abs(itemCenter - viewportCenter)
            }?.index ?: 0
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        LazyRow(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .clipToBounds(),
            flingBehavior = rememberSnapFlingBehavior(listState)
        ) {
            itemsIndexed(mediaItems) { index, media ->
                Box(
                    modifier = Modifier
                        .fillParentMaxHeight()
                        .aspectRatio(1f)
                ) {
                    if (index == centeredIndex) {
                        // 중심 아이템일 경우
                        when (media) {
                            is MediaItem.Image -> {
                                AsyncImage(
                                    model = media.url,
                                    contentDescription = "Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }

                            is MediaItem.Video -> {
                                VideoPlayer(videoUrl = media.url)
                            }
                        }
                    } else {
                        // 중심 외의 아이템은 이미지 또는 썸네일로만 보여줌
                        if (media is MediaItem.Image) {
                            AsyncImage(
                                model = media.url,
                                contentDescription = "Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        } else {
                            // 영상의 경우도 그냥 이미지처럼 썸네일 대체
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(LocalColors.current.black)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.PlayArrow,
                                    contentDescription = "Play",
                                    tint = LocalColors.current.white,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .size(48.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        // 페이지 인디케이터
        Text(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp)
                .background(
                    color = LocalColors.current.black.copy(alpha = 0.6f),
                    shape = CircleShape
                )
                .padding(horizontal = 8.dp, vertical = 4.dp),
            text = "${centeredIndex + 1} / ${mediaItems.size}",
            color = LocalColors.current.white,
            style = LocalTypography.current.body1
        )
    }
}

