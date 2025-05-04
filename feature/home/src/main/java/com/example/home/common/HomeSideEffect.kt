package com.example.home.common

import com.example.base.mvi.SideEffect

sealed class HomeSideEffect: SideEffect {

    data class StartVideoDetail(val videoId: String): HomeSideEffect()
    data class ShowToast(val message: String): HomeSideEffect()
}