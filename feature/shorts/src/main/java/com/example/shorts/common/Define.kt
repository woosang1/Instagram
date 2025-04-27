package com.example.shorts.common

import com.example.model.ui.ContentInfo
import com.example.model.ui.MediaItem

val testList = listOf(
    ContentInfo(
        id = "1",
        thumbnails = listOf(
            MediaItem.Image(
                id = "img1",
                imageUrl = "https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg"
            ),
            MediaItem.Video(
                id = "vid1",
                videoUrl = "https://video.com/1",
                thumbnailsUrl = "https://thumbnails.com/1"
            )
        ),
        profileUrl = "https://channel-thumbnail.com/1",
        title = "카리나",
        profileName = "",
        description = "이상한 나라의 앨리스",
        viewCount = "1.2M views",
        timeAgo = "1 day ago"
    ),
    ContentInfo(
        id = "2",
        thumbnails = listOf(
            MediaItem.Image(
                id = "img2",
                imageUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Video(
                id = "vid2",
                videoUrl = "https://video.com/2",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75",
                isMute = false
            )
        ),
        profileUrl = "https://channel-thumbnail.com/2",
        title = "기안84",
        profileName = "",
        description = "모두의 인생",
        viewCount = "500K views",
        timeAgo = "2 hours ago"
    ),
    ContentInfo(
        id = "3",
        thumbnails = listOf(
            MediaItem.Image(
                id = "img3",
                imageUrl = "https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"
            ),
            MediaItem.Video(
                id = "vid3",
                videoUrl = "https://video.com/3",
                thumbnailsUrl = "https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"
            )
        ),
        profileUrl = "https://channel-thumbnail.com/3",
        title = "강아지 일상",
        profileName = "",
        description = "귀여워",
        viewCount = "2.4M views",
        timeAgo = "5 days ago"
    )
)
