package com.example.home

import com.example.base.base.BaseViewModel
import com.example.home.common.HomeEvent
import com.example.home.common.HomeSideEffect
import com.example.home.common.HomeState
import com.example.home.common.HomeUiState
import com.example.home.common.Section
import com.example.home.common.testContentList
import com.example.home.common.testStoryList
import com.example.model.ui.ContentInfo
import com.example.model.ui.MediaItem
import com.example.utils.FeatureErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel<HomeEvent, HomeState, HomeSideEffect>(), FeatureErrorHandler {

    override fun createInitialState(): HomeState = HomeState(homeUiState = HomeUiState.Loading)

    override fun handleEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.Init -> {
                setState {
                    copy(
                        homeUiState = HomeUiState.Content(
                            section = ArrayList<Section>().apply {
                                add(Section.Story(storyList = testStoryList))
                                testContentList.forEachIndexed { index, contentInfo ->
                                    add(Section.Feed(contentInfo = contentInfo))
                                }
                            }
                        )
                    )
                }
            }

            is HomeEvent.ClickMuteIcon -> {
                val currentState = state.value.homeUiState
                if (currentState is HomeUiState.Content) {
                    val updatedSectionList = currentState.section.map { section ->
                        if (section is Section.Feed) {
                            val content = section.contentInfo
                            if (content.id == event.contentId) {
                                val updatedThumbnails = content.thumbnails.map { media ->
                                    if (media is MediaItem.Video && media.id == event.mediaId) {
                                        media.copy(isMute = !media.isMute)
                                    } else media
                                }
                                content.copy(thumbnails = updatedThumbnails)
                            }
                            section.copy(contentInfo = content)
                        } else {
                            section
                        }
                    }

                    // 상태 업데이트
                    setState {
                        copy(
                            homeUiState = currentState.copy(
                                section = updatedSectionList
                            )
                        )
                    }
                }
            }
        }
    }

    override fun handleError(throwable: Throwable) {
        TODO("Not yet implemented")
    }
}
