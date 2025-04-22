package com.example.model.ui

sealed class MediaItem(
    open val id: String,
    open val url: String
) {
    data class Image(
        override val id: String,
        override val url: String
    ) : MediaItem(id = id, url = url)

    data class Video(
        override val id: String,
        override val url: String,
        var isMute: Boolean = true
    ) : MediaItem(id = id, url = url)
}
