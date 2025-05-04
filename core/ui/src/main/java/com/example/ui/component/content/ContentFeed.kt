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
import com.example.utils.extension.noRippleClickable
import com.example.resource.R as ResourceR

@Composable
fun ContentFeed(
    modifier: Modifier = Modifier,
    isShowingItem: Boolean,
    contentInfo: ContentInfo,
    onProfileClick: () -> Unit,
    onLikeClick: () -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit,
    onClickVideo: (videoId: String) -> Unit,
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
                    model = contentInfo.profileUrl,
                    contentDescription = "Channel Thumbnail",
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            //  채널 이름
            Text(
                text = contentInfo.profileName,
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

        MediaHorizontalPager(
            contentId = contentInfo.id,
            mediaItems = contentInfo.thumbnails,
            isShowingItem = isShowingItem,
            onMuteClick = onMuteClick,
            onClickVideo = onClickVideo
        )

        // 아이콘 바 (좋아요, 댓글, 공유)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp, vertical = 2.dp),
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
internal fun MediaHorizontalPager(
    contentId: String,
    mediaItems: List<MediaItem>,
    isShowingItem: Boolean,
    onClickVideo: (videoId: String) -> Unit,
    onMuteClick: (contentId: String, mediaId: String) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { mediaItems.size })

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f) // 정사각형
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val media = mediaItems[page]
            val isAutoPlay = (pagerState.currentPage == page) && isShowingItem

            Box(
                modifier = Modifier
                    .fillMaxSize()
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
                                .noRippleClickable { onClickVideo(media.id) }
                        ) {
                            VideoPlayer(
                                thumbnailsUrl = media.thumbnailsUrl,
                                videoUrl = media.videoUrl,
                                isAutoPlay = isAutoPlay,
                                isMute = if (isAutoPlay) media.isMute else false
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
            text = "${pagerState.currentPage + 1} / ${mediaItems.size}",
            color = LocalColors.current.white,
            style = LocalTypography.current.body1
        )
    }
}
