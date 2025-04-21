package com.example.model.ui

sealed class MediaItem(val url: String) {
    class Image(url: String) : MediaItem(url)
    class Video(url: String) : MediaItem(url)
}