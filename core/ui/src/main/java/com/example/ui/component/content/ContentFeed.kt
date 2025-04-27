package com.example.ui.component.content

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.model.ui.ContentInfo
import com.example.model.ui.MediaItem
import com.example.ui.component.video.VideoPlayer
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import com.example.utils.log.DebugLog
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import com.example.resource.R as ResourceR
import kotlin.math.abs

@Composable
fun ContentFeed(
    modifier: Modifier = Modifier,
    isShowingItem: Boolean,
    contentInfo: ContentInfo,
    onProfileClick: () -> Unit,
    onLikeClick: () -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit,
    onMuteClick: (contentId: String, mediaId: String) -> Unit,
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
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    model = contentInfo.channelThumbnailUrl,
                    contentDescription = "Channel Thumbnail",
                    contentScale = ContentScale.Crop
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

        MediaHorizontalList(
            contentId = contentInfo.id,
            mediaItems = contentInfo.thumbnails,
            isShowingItem = isShowingItem,
            onMuteClick = onMuteClick
        )

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
fun MediaHorizontalList(
    contentId: String,
    mediaItems: List<MediaItem>,
    isShowingItem: Boolean,
    onMuteClick: (contentId: String, mediaId: String) -> Unit
) {
    val listState = rememberLazyListState()
    val currentPage = remember { mutableIntStateOf(0) }

    LaunchedEffect(listState) {
        snapshotFlow { listState.isScrollInProgress }
            .distinctUntilChanged()
            .collect { isScrolling ->
                if (!isScrolling) {
                    // Snap 애니메이션이 완전히 끝나도록 살짝 delay
                    delay(80) // 이 값은 필요시 조절 가능

                    val layoutInfo = listState.layoutInfo
                    val visibleItems = layoutInfo.visibleItemsInfo
                    val center = layoutInfo.viewportStartOffset + layoutInfo.viewportEndOffset / 2

                    val closestItem = visibleItems.minByOrNull { item ->
                        val itemCenter = item.offset + item.size / 2
                        abs(itemCenter - center)
                    }

                    closestItem?.index?.let {
                        currentPage.value = it
                        DebugLog("🎯 Snap 이후 확정된 currentPage: $it")
                    }
                }
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
            itemsIndexed(mediaItems, key = { index, media -> media.id }) { index, media ->
                val isSelected = (currentPage.intValue == index)
                val isAutoPlay = (isSelected && isShowingItem)
                DebugLog("index : ${index} / isSelected : ${isSelected} / currentPage : ${currentPage.intValue}")
                DebugLog("isShowingItem : ${isShowingItem}")
                DebugLog("isAutoPlay : ${isAutoPlay}")

                Box(
                    modifier = Modifier
                        .fillParentMaxHeight()
                        .aspectRatio(1f)
                ) {
                    when (media) {
                        is MediaItem.Image -> {
                            AsyncImage(
                                modifier = Modifier.fillMaxSize(),
                                model = media.imageUrl,
                                contentDescription = "Image",
                                contentScale = ContentScale.Crop,
                                placeholder = painterResource(ResourceR.drawable.placeholder)
                            )
                        }

                        is MediaItem.Video -> {
                            Box(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                if(isSelected){
                                    VideoPlayer(
                                        videoUrl = media.videoUrl,
                                        isAutoPlay = isAutoPlay,
                                        isMute = if (isAutoPlay) media.isMute else false,
                                        onReadyState = {}
                                    )
                                    VolumeToggleButton(
                                        modifier = Modifier
                                            .align(Alignment.BottomEnd)
                                            .padding(end = 8.dp, bottom = 8.dp),
                                        isMuted = media.isMute,
                                        onToggleVolume = {
                                            onMuteClick(contentId, media.id)
                                        }
                                    )
                                }
                                else{
                                    AsyncImage(
                                        modifier = Modifier.fillMaxSize(),
                                        model = media.thumbnailsUrl,
                                        contentDescription = "Image",
                                        contentScale = ContentScale.Crop,
                                        placeholder = painterResource(ResourceR.drawable.placeholder)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // 페이지 인디케이터
        Text(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
                .background(
                    color = LocalColors.current.black.copy(alpha = 0.6f),
                    shape = CircleShape
                )
                .padding(horizontal = 8.dp, vertical = 4.dp),
            text = "${currentPage.intValue + 1} / ${mediaItems.size}",
            color = LocalColors.current.white,
            style = LocalTypography.current.body1
        )
    }
}
