package com.example.model.ui

sealed class MediaItem(open val url: String) {
    data class Image(override val url: String) : MediaItem(url)
    data class Video(override val url: String, var isMute: Boolean = true) : MediaItem(url)
}
