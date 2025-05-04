package com.example.shorts

import com.example.base.base.BaseViewModel
import com.example.shorts.common.ShortsEvent
import com.example.shorts.common.ShortsSideEffect
import com.example.shorts.common.ShortsState
import com.example.shorts.common.ShortsUiState
import com.example.utils.FeatureErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShortsViewModel @Inject constructor(
) : BaseViewModel<ShortsEvent, ShortsState, ShortsSideEffect>(), FeatureErrorHandler {
    override fun createInitialState(): ShortsState = ShortsState(shortsUiState = ShortsUiState.Loading)
    override fun handleEvent(event: ShortsEvent) {
    }

    override fun handleError(throwable: Throwable) {
    }

}
