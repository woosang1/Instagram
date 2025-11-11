package com.example.search.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.model.ui.ContentInfo
import com.example.model.ui.MediaItem
import com.example.resource.R
import com.example.ui.component.IGImage
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
            val firstItem = item.mediaItemList.first()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .noRippleClickable { onItemClick(item) }
            ) {
                Box {
                    IGImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .aspectRatio(1f),
                        model = when (firstItem) {
                            is MediaItem.Video -> firstItem.thumbnailsUrl
                            is MediaItem.Image -> firstItem.imageUrl
                        },
                        contentDescription = stringResource(id = R.string.content_description_image),
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(R.drawable.placeholder)
                    )
                    IGImage(
                        modifier = Modifier
                            .size(28.dp)
                            .align(Alignment.TopEnd)
                            .padding(2.dp),
                        painter = painterResource(
                            when (firstItem) {
                                is MediaItem.Video -> R.drawable.video
                                is MediaItem.Image -> R.drawable.page
                            }
                        ),
                        contentDescription = stringResource(id = R.string.content_description_media_type),
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        }
    }
}
