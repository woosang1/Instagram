package com.example.home.common

import androidx.annotation.StringRes
import com.example.base.mvi.SideEffect

sealed class HomeSideEffect : SideEffect {

    data class StartVideoDetail(val videoId: String) : HomeSideEffect()
    data class ShowToast(@StringRes val messageResId: Int) : HomeSideEffect()
}