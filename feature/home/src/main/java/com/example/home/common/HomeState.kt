package com.example.home.common

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.base.mvi.State
import com.example.model.ui.ContentInfo

@Immutable
data class HomeState(
    val homeUiState : HomeUiState
): State

@Stable
sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Content(
        val section: List<Section>
    ) : HomeUiState
    data object Error : HomeUiState
}