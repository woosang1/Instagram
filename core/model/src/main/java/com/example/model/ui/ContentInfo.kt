package com.example.model.ui

data class ContentInfo(
    val id: String,
    val thumbnails: List<MediaItem>,
    val channelThumbnailUrl: String,
    val title: String,
    val channelName: String,
    val viewCount: String,
    val timeAgo: String
)