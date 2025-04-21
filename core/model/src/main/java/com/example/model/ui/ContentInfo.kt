package com.example.model.ui

data class ContentInfo(
    val thumbnailUrls: List<String>,
    val channelThumbnailUrl: String,
    val title: String,
    val channelName: String,
    val viewCount: String,
    val timeAgo: String
)