package com.example.shorts.common

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.base.mvi.State

@Immutable
data class ShortsState(
    val shortsUiState : ShortsUiState
): State

@Stable
sealed interface ShortsUiState {
    data object Loading : ShortsUiState
    data class Content(val dd: String) : ShortsUiState
    data object Error : ShortsUiState
}