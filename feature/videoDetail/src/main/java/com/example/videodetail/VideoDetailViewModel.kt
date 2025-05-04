package com.example.videodetail

import com.example.base.base.BaseViewModel
import com.example.utils.FeatureErrorHandler
import com.example.videodetail.common.VideoDetailEvent
import com.example.videodetail.common.VideoDetailSideEffect
import com.example.videodetail.common.VideoDetailState
import com.example.videodetail.common.VideoDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VideoDetailViewModel @Inject constructor(
) : BaseViewModel<VideoDetailEvent, VideoDetailState, VideoDetailSideEffect>(), FeatureErrorHandler {

    override fun createInitialState(): VideoDetailState = VideoDetailState(videoDetailUiState = VideoDetailUiState.Loading)

    override fun handleEvent(event: VideoDetailEvent) {
        when (event) {
            is VideoDetailEvent.Init -> {

            }
            is VideoDetailEvent.ClickVideo -> {
            }

            is VideoDetailEvent.ClickMuteIcon -> {
                }
        }
    }

    override fun handleError(throwable: Throwable) {
        TODO("Not yet implemented")
    }
}
