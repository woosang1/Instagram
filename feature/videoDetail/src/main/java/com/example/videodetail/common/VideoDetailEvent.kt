package com.example.videodetail.common

import com.example.base.mvi.Event

sealed interface VideoDetailEvent: Event {
    data object Init : VideoDetailEvent
    data class ClickVideo(val videoId: String) : VideoDetailEvent
    data class ClickMuteIcon(
        val contentId: String,
        val mediaId: String,
    ) : VideoDetailEvent
}

