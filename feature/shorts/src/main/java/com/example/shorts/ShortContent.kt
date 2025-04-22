package com.example.shorts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.resource.R as ResourceR

@Composable
internal fun ShortContent(
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(10) { index ->
            ShortView(index)
        }
    }
}

@Composable
internal fun ShortView(index: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.blue),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = "https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg",
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(ResourceR.drawable.placeholder)
        )
        ShortOverlayUI(
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}
