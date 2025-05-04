package com.example.shorts.common

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.base.mvi.State
import com.example.model.ui.ContentInfo

@Immutable
data class ShortsState(
    val shortsUiState : ShortsUiState
): State

@Stable
sealed interface ShortsUiState {
    data object Loading : ShortsUiState
    data class Content(
        val contentInfoList: List<ContentInfo>
    ) : ShortsUiState
    data object Error : ShortsUiState
}