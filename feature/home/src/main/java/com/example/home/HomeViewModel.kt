package com.example.home

import com.example.base.base.BaseViewModel
import com.example.home.common.HomeEvent
import com.example.home.common.HomeSideEffect
import com.example.home.common.HomeState
import com.example.home.common.HomeUiState
import com.example.home.common.testContentList
import com.example.utils.FeatureErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel<HomeEvent, HomeState, HomeSideEffect>(), FeatureErrorHandler {

    override fun createInitialState(): HomeState = HomeState(homeUiState = HomeUiState.Loading)

    override fun handleEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.Init -> {
                setState {
                    copy(
                        homeUiState = HomeUiState.Content(
                            contentList = testContentList
                        )
                    )
                }
            }
        }
    }

    override fun handleError(throwable: Throwable) {
        TODO("Not yet implemented")
    }
}
