package com.example.model.ui

data class ContentInfo(
    val id: String,
    val mediaItemList: List<MediaItem>,
    val profileUrl: String,
    val profileName: String,
    val title: String,
    val description: String = "",
    val viewCount: String,
    val timeAgo: String
)