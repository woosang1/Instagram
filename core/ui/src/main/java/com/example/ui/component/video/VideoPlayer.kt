package com.example.ui.component.video

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.OptIn
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import coil.compose.AsyncImage
import com.example.designsystem.theme.LocalColors
import com.example.ui.component.licenseUrl
import kotlinx.coroutines.delay
import com.example.resource.R as ResourceR


@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(
    thumbnailsUrl: String,
    videoUrl: String,
    isAutoPlay: Boolean = true,
    isMute: Boolean = true,
    isShowProcessBar: Boolean = false
) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val isVideoReady = remember { mutableStateOf(false) }
    val exoPlayer = remember(videoUrl) {
        // DRM 설정: Widevine 사용 및 라이선스 서버 URI 지정
        val drmConfig = MediaItem.DrmConfiguration.Builder(C.WIDEVINE_UUID)
            .setLicenseUri(licenseUrl)
            .build()

        val mediaItem = MediaItem.Builder()
            .setUri(videoUrl)
            .setDrmConfiguration(drmConfig)
            .build()

        ExoPlayer.Builder(context).build().apply {
            repeatMode = Player.REPEAT_MODE_ONE
            setMediaItem(mediaItem)
            addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(state: Int) {
                    when (state) {
                        Player.STATE_BUFFERING -> Unit
                        Player.STATE_READY -> {
                            isVideoReady.value = true
                        }
                        Player.STATE_ENDED -> Unit
                        Player.STATE_IDLE -> Unit
                    }
                }
                override fun onIsPlayingChanged(isPlaying: Boolean) { }
            })
        }
    }
    var currentPosition by remember { mutableLongStateOf(0L) }
    var dragProgress by remember { mutableFloatStateOf(-1f) }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    LaunchedEffect(videoUrl) {
        val mediaItem = MediaItem.fromUri(videoUrl)
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
    }

    LaunchedEffect(isMute) {
        exoPlayer.volume = if (isMute) 0f else 1f
    }

    LaunchedEffect(isAutoPlay) {
        exoPlayer.playWhenReady = isAutoPlay
        if (isAutoPlay) {
            exoPlayer.play()
        } else {
            exoPlayer.pause()
        }
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> exoPlayer.pause()
                Lifecycle.Event.ON_DESTROY -> {
                    exoPlayer.stop()
                    exoPlayer.release()
                }

                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    LaunchedEffect(exoPlayer) {
        while (true) {
            currentPosition = exoPlayer.currentPosition
            delay(300L) // 0.3초 간격으로 업데이트
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidView(
            factory = {
                PlayerView(it).apply {
                    player = exoPlayer
                    useController = false
                    layoutParams = FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                }
            },
            modifier = Modifier.fillMaxSize()
        )

        if (isAutoPlay) {
            AnimatedVisibility(
                visible = !isVideoReady.value,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = thumbnailsUrl,
                    contentDescription = "Thumbnail",
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(ResourceR.drawable.placeholder)
                )
            }
        }
        else{
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = thumbnailsUrl,
                contentDescription = "Thumbnail",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(ResourceR.drawable.placeholder)
            )
        }

        // 하단 프로그래스바
        if (isShowProcessBar){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .align(Alignment.BottomCenter)
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures(
                            onDragStart = { offset ->
                                val ratio = (offset.x / size.width).coerceIn(0f, 1f)
                                dragProgress = ratio
                            },
                            onHorizontalDrag = { change, dragAmount ->
                                change.consume()
                                dragProgress = (dragProgress + dragAmount / size.width).coerceIn(0f, 1f)
                            },
                            onDragEnd = {
                                val seekPosition = (exoPlayer.duration * dragProgress).toLong()
                                exoPlayer.seekTo(seekPosition)
                                dragProgress = -1f 
                            },
                            onDragCancel = {
                                dragProgress = -1f
                            }
                        )
                    }
            ) {
                val progress = if (dragProgress >= 0f) dragProgress else currentPosition / exoPlayer.duration.toFloat()

                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp),
                    color = LocalColors.current.red,
                    trackColor = LocalColors.current.darkGray,
                )
            }
        }
    }

}