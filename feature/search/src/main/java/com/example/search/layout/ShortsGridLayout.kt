package com.example.search.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.model.ui.ContentInfo
import com.example.model.ui.MediaItem
import com.example.resource.R
import com.example.utils.extension.noRippleClickable

@Composable
fun ShortsGridLayout(
    modifier: Modifier = Modifier,
    items: List<ContentInfo>,
    onItemClick: (ContentInfo) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier,
        contentPadding = PaddingValues(0.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(items) { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .noRippleClickable { onItemClick(item) }
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .aspectRatio(1f),
                    model = when (item.mediaItemList.first()) {
                        is MediaItem.Video -> (item.mediaItemList.first() as MediaItem.Video).thumbnailsUrl
                        is MediaItem.Image -> (item.mediaItemList.first() as MediaItem.Image).imageUrl
                    },
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.placeholder)
                )
            }
        }
    }
}
