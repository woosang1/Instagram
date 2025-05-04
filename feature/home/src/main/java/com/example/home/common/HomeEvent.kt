package com.example.home.common

import com.example.base.mvi.Event

sealed interface HomeEvent : Event {
    data object Init : HomeEvent
    data class ClickVideo(val videoId: String) : HomeEvent
    data class ClickMuteIcon(
        val contentId: String,
        val mediaId: String,
    ) : HomeEvent
    data object Refresh : HomeEvent
}

