package com.example.shorts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.ui.component.IGText

@Composable
fun ShortOverlayUI(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    onLikeClick: () -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // 오른쪽 버튼 그룹
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            IconButton(onClick = onLikeClick) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Like",
                    tint = LocalColors.current.white,
                    modifier = Modifier.size(32.dp)
                )
            }

            IconButton(onClick = onCommentClick) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Comment",
                    tint = LocalColors.current.white,
                    modifier = Modifier.size(32.dp)
                )
            }

            IconButton(onClick = onShareClick) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    tint = LocalColors.current.white,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        // 타이틀 & 설명
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(end = 72.dp)
        ) {
            IGText(
                text = title,
                color = LocalColors.current.white,
                style = LocalTypography.current.body1,
                modifier = Modifier,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(4.dp))
            IGText(
                text = description,
                color = LocalColors.current.white,
                style = LocalTypography.current.body1,
                modifier = Modifier,
                maxLines = 2
            )
        }
    }
}