package com.example.videodetail.common

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.base.mvi.State

@Immutable
data class VideoDetailState(
    val videoDetailUiState : VideoDetailUiState
): State

@Stable
sealed interface VideoDetailUiState {
    data object Loading : VideoDetailUiState
    data object Content : VideoDetailUiState
    data object Error : VideoDetailUiState
}