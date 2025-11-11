package com.example.home

import androidx.lifecycle.viewModelScope
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
import com.example.utils.log.DebugLog
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel<HomeEvent, HomeState, HomeSideEffect>(), FeatureErrorHandler {

    private companion object {
        private const val MAX_PAGE_COUNT = 3
    }

    private var nextPage = 1
    private var isLoadingNextPage = false

    override fun createInitialState(): HomeState = HomeState(homeUiState = HomeUiState.Loading)

    override fun handleEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.Init -> {
                loadInitial()
            }
            is HomeEvent.ClickVideo -> {
                DebugLog("is HomeEvent.ClickVideo -> {")
                setEffect(HomeSideEffect.StartVideoDetail(videoId = event.videoId))
            }

            is HomeEvent.ClickMuteIcon -> {
                val currentState = state.value.homeUiState
                if (currentState is HomeUiState.Content) {
                    DebugLog("currentState : ${currentState.toString()}")
                    val updatedSectionList = currentState.section.map { section ->
                        if (section is Section.Feed) {
                            val content = section.contentInfo
                            val updatedContent = if (content.id == event.contentId) {
                                val updatedThumbnails = content.mediaItemList.map { media ->
                                    if (media is MediaItem.Video && media.id == event.mediaId) {
                                        media.copy(isMute = !media.isMute)
                                    } else media
                                }
                                content.copy(mediaItemList = updatedThumbnails)
                            } else {
                                content
                            }
                            section.copy(contentInfo = updatedContent)
                        } else {
                            section
                        }
                    }
                    setState {
                        copy(
                            homeUiState = currentState.copy(
                                section = updatedSectionList
                            )
                        )
                    }
                }
            }
            is HomeEvent.Refresh -> {
                loadInitial()
                setEffect(HomeSideEffect.ShowToast("새로고침 완료"))
            }
            is HomeEvent.LoadNextPage -> {
                loadNextPage()
            }
        }
    }

    override fun handleError(throwable: Throwable) {
        TODO("Not yet implemented")
    }

    private fun loadInitial() {
        nextPage = 1
        isLoadingNextPage = false
        setState {
            copy(
                homeUiState = HomeUiState.Content(
                    section = buildInitialSections(),
                    isAppending = false,
                    hasMore = MAX_PAGE_COUNT > 1
                )
            )
        }
    }

    private fun loadNextPage() {
        val currentState = state.value.homeUiState
        if (isLoadingNextPage || currentState !is HomeUiState.Content) return
        if (!currentState.hasMore) return

        isLoadingNextPage = true

        setState {
            copy(
                homeUiState = currentState.copy(isAppending = true)
            )
        }

        viewModelScope.launch {
            try {
                delay(150) // Simulated fetch latency
                val page = nextPage
                val feedSections = testContentList.map { content ->
                    Section.Feed(contentInfo = content.withPageSuffix(page))
                }
                val hasMore = page + 1 <= MAX_PAGE_COUNT
                setState {
                    copy(
                        homeUiState = currentState.copy(
                            section = currentState.section + feedSections,
                            isAppending = false,
                            hasMore = hasMore
                        )
                    )
                }
                nextPage = page + 1
            } finally {
                isLoadingNextPage = false
            }
        }
    }

    private fun buildInitialSections(): List<Section> =
        buildList {
            add(Section.Header)
            add(Section.Story(storyList = testStoryList))
            testContentList.forEach { content ->
                add(Section.Feed(contentInfo = content))
            }
        }

    private fun MediaItem.withPageSuffix(page: Int): MediaItem =
        when (this) {
            is MediaItem.Image -> copy(id = "${id}_$page")
            is MediaItem.Video -> copy(id = "${id}_$page")
        }

    private fun ContentInfo.withPageSuffix(page: Int): ContentInfo =
        copy(
            id = "${id}_$page",
            mediaItemList = mediaItemList.map { it.withPageSuffix(page) }
        )
}
