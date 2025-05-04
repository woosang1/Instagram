package com.example.shorts

import com.example.base.base.BaseViewModel
import com.example.model.ui.MediaItem
import com.example.shorts.common.ShortsEvent
import com.example.shorts.common.ShortsSideEffect
import com.example.shorts.common.ShortsState
import com.example.shorts.common.ShortsUiState
import com.example.shorts.common.testList
import com.example.utils.FeatureErrorHandler
import com.example.utils.log.DebugLog
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShortsViewModel @Inject constructor(
) : BaseViewModel<ShortsEvent, ShortsState, ShortsSideEffect>(), FeatureErrorHandler {
    override fun createInitialState(): ShortsState = ShortsState(shortsUiState = ShortsUiState.Loading)
    override fun handleEvent(event: ShortsEvent) {
        when(event){
            is ShortsEvent.Init -> {
                setState { copy(shortsUiState = ShortsUiState.Content(
                    contentInfoList = testList
                )) }
            }
            is ShortsEvent.ClickVideo -> {
                DebugLog("is ShortsEvent.ClickVideo -> ")
                DebugLog("event.id : ${event.id}")
                val currentState = state.value.shortsUiState
                if (currentState is ShortsUiState.Content) {
                    val newList = currentState.contentInfoList.map { contentInfo ->
                        val updatedThumbnails = contentInfo.mediaItemList.map { mediaItem ->
                            DebugLog("mediaItem.id : ${mediaItem.id}")
                            if (mediaItem is MediaItem.Video && mediaItem.id == event.id) {
                                DebugLog("mediaItem is MediaItem.Video && mediaItem.id == event.id")
                                mediaItem.copy(isMute = !mediaItem.isMute)
                            } else {
                                mediaItem
                            }
                        }
                        contentInfo.copy(mediaItemList = updatedThumbnails)
                    }
                    DebugLog("newList : ${newList.toString()}")

                    setState {
                        copy(
                            shortsUiState = ShortsUiState.Content(
                                contentInfoList = newList
                            )
                        )
                    }
                }
            }
        }
    }

    override fun handleError(throwable: Throwable) {
    }

}
