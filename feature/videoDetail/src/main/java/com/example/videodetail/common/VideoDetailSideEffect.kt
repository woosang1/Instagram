package com.example.videodetail.common

import com.example.base.mvi.SideEffect

sealed class VideoDetailSideEffect: SideEffect {

    data class StartVideoDetail(val videoId: String): VideoDetailSideEffect()
}