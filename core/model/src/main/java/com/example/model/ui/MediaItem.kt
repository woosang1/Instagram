package com.example.model.ui

sealed class MediaItem(
    open val id: String,
) {
    data class Image(
        override val id: String,
        val imageUrl: String
    ) : MediaItem(id = id)

    data class Video(
        override val id: String,
        val videoUrl: String,
        val thumbnailsUrl: String,
        var isMute: Boolean = true
    ) : MediaItem(id = id)
}
