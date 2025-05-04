package com.example.shorts.common

import com.example.base.mvi.Event

sealed interface ShortsEvent: Event {
    data object Init : ShortsEvent
}

