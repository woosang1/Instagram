package com.example.videodetail

import androidx.compose.runtime.Composable
import com.example.ui.component.content.ContentVideo
import com.example.ui.component.content.VideoTitle

@Composable
internal fun VideoDetailContent() {

    ContentVideo(
        thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75",
        videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
        videoTitle = VideoTitle.BACK_ICON,
        onClickEvent = {}
    )

}
