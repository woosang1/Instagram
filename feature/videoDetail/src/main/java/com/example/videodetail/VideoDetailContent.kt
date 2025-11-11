package com.example.videodetail

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import com.example.ui.component.IGText
import com.example.ui.component.content.ContentVideo
import com.example.ui.component.content.VideoTitle
import com.example.ui.component.video.VideoPlayerBufferConfig
import com.example.ui.component.video.VideoPlayerConfig
import com.example.ui.component.video.VideoPlayerDrmConfig

@Composable
internal fun VideoDetailContent(
    onBackEvent: () -> Unit
) {
    var isBuffering by remember { mutableStateOf(false) }
    var lastErrorMessage by remember { mutableStateOf<String?>(null) }

    val bufferConfig = VideoPlayerBufferConfig(
        minBufferMs = 15_000,
        maxBufferMs = 80_000,
        playbackBufferMs = 3_000,
        rebufferMs = 5_000
    )

    val playerConfig = VideoPlayerConfig(
        drmConfig = VideoPlayerDrmConfig(
            licenseUrl = "https://proxy.uat.widevine.com/proxy?provider=widevine_test"
        ),
        bufferConfig = bufferConfig,
        onBufferStateChanged = { isBuffering = it },
        onError = { throwable -> lastErrorMessage = throwable.message }
    )

    ContentVideo(
        thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75",
        videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
        videoTitle = VideoTitle.BACK_ICON,
        onClickVideoEvent = {},
        onClickBackIcon = onBackEvent,
        playerConfig = playerConfig
    )

    lastErrorMessage?.let { message ->
        IGText(
            text = message,
            color = LocalColors.current.red,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}
