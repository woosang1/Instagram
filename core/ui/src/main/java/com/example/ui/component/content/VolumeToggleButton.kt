package com.example.ui.component.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import com.example.resource.R

@Composable
fun VolumeToggleButton(
    modifier: Modifier = Modifier,
    isMuted: Boolean,
    onToggleVolume: () -> Unit,
) {
    Box(
        modifier = modifier
            .size(40.dp)
            .background(LocalColors.current.black.copy(alpha = 0.5f), shape = CircleShape)
            .clickable { onToggleVolume() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape),
            painter = painterResource(id = if(isMuted) R.drawable.mute_on else R.drawable.mute_off),
            contentDescription = "Channel Thumbnail",
            contentScale = ContentScale.Crop,
        )
    }
}
