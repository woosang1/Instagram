package com.example.ui.component.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.model.ui.ContentInfo
import com.example.utils.extension.noRippleClickable

@Composable
fun ContentCard(
    modifier: Modifier = Modifier,
    contentInfo: ContentInfo,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .noRippleClickable { onClick() }
    ) {
        // 썸네일
        AsyncImage(
            model = contentInfo.thumbnailUrl,
            contentDescription = "Content Thumbnail",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
        ) {
            // 채널 썸네일
            AsyncImage(
                model = contentInfo.channelThumbnailUrl,
                contentDescription = "Channel Thumbnail",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(12.dp))

            // 텍스트 정보
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 12.dp)
            ) {

                Text(
                    text = contentInfo.title,
                    modifier = Modifier,
                    style = LocalTypography.current.headline2,
                    color = LocalColors.current.white,
                    maxLines = 2,
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${contentInfo.channelName} • ${contentInfo.viewCount} • ${contentInfo.timeAgo}",
                    modifier = Modifier,
                    style = LocalTypography.current.headline2,
                    color = LocalColors.current.white,
                    maxLines = 1,
                )
            }

//            Image(
//                imageVector = Icons.Default.MoreVert,
//                contentDescription = "More options",
//                tint = LocalColors.current.gray
//            )
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}
