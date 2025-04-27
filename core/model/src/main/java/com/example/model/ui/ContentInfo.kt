package com.example.model.ui

data class ContentInfo(
    val id: String,
    val thumbnails: List<MediaItem>,
    val profileUrl: String,
    val profileName: String,
    val title: String,
    val description: String = "",
    val viewCount: String,
    val timeAgo: String
)