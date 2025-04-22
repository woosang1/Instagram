package com.example.ui.component.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.foundation.shape.CircleShape

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
        Icon(
            imageVector = if (isMuted) Icons.Default.Build else Icons.Default.Create,
            contentDescription = "Toggle Volume",
            tint = LocalColors.current.white
        )
    }
}
