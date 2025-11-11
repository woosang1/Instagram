package com.example.ui.component.video

import androidx.media3.common.C

/**
 * DRM 관련 설정.
 */
data class VideoPlayerDrmConfig(
    val licenseUrl: String,
    val requestHeaders: Map<String, String> = emptyMap()
)

/**
 * 버퍼링 파라미터 설정.
 *
 * @param minBufferMs 최소 버퍼링 시간(ms)
 * @param maxBufferMs 최대 버퍼링 시간(ms)
 * @param playbackBufferMs 재생 시작을 위한 버퍼 최소 시간(ms)
 * @param rebufferMs 재버퍼링 시 필요 버퍼(ms)
 */
data class VideoPlayerBufferConfig(
    val minBufferMs: Int = 10_000,
    val maxBufferMs: Int = 50_000,
    val playbackBufferMs: Int = 2_500,
    val rebufferMs: Int = 5_000
)

/**
 * 플레이어 동작 전반을 제어하기 위한 설정 묶음.
 */
data class VideoPlayerConfig(
    val drmConfig: VideoPlayerDrmConfig? = null,
    val bufferConfig: VideoPlayerBufferConfig = VideoPlayerBufferConfig(),
    val playbackSpeed: Float = 1f,
    val isLooping: Boolean = true,
    val seekClosestSync: Boolean = true,
    val onBufferStateChanged: (Boolean) -> Unit = {},
    val onError: (Throwable) -> Unit = {}
) {
    companion object {
        val Default = VideoPlayerConfig()
        val WidevineTest = VideoPlayerConfig(
            drmConfig = VideoPlayerDrmConfig(
                licenseUrl = "https://proxy.uat.widevine.com/proxy?provider=widevine_test"
            )
        )
    }

    val drmSchemeUuid = C.WIDEVINE_UUID
}

