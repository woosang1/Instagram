package com.example.ui.component.content

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.model.ui.ContentInfo

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

        ThumbnailHorizontalList(thumbnailUrls = contentInfo.thumbnailUrls)

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
fun ThumbnailHorizontalList(thumbnailUrls: List<String>) {
    val listState = rememberLazyListState()

    val currentPage by remember {
        derivedStateOf {
            listState.layoutInfo.visibleItemsInfo.firstOrNull()?.index?.plus(1) ?: 1
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
                .clipToBounds()
        ) {
            items(thumbnailUrls.size) { index ->
                AsyncImage(
                    model = thumbnailUrls[index],
                    contentDescription = "Post Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .aspectRatio(1f)
                )
            }
        }

        Text(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp)
                .background(
                    color = LocalColors.current.black.copy(alpha = 0.6f),
                    shape = CircleShape
                )
                .padding(horizontal = 8.dp, vertical = 4.dp),
            text = "$currentPage / ${thumbnailUrls.size}",
            color = LocalColors.current.white,
            style = LocalTypography.current.body1
        )
    }
}