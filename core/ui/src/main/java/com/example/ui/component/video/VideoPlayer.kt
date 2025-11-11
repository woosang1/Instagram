package com.example.ui.component.video

import android.graphics.BitmapFactory
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.OptIn
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.PlaybackParameters
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.DefaultLoadControl
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.LoadControl
import androidx.media3.exoplayer.SeekParameters
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.example.designsystem.theme.LocalColors
import com.example.resource.R as ResourceR
import com.example.ui.component.IGImage
import com.example.utils.extension.dpToPixel
import com.example.utils.log.DebugLog
import kotlinx.coroutines.delay
import java.io.IOException

@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(
    thumbnailsUrl: String,
    videoUrl: String,
    isAutoPlay: Boolean = true,
    isMute: Boolean = true,
    isShowProcessBar: Boolean = false,
    config: VideoPlayerConfig = VideoPlayerConfig.Default,
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    var isVideoReady by remember { mutableStateOf(false) }
    var isBuffering by remember { mutableStateOf(false) }
    var currentPosition by remember { mutableLongStateOf(0L) }
    var dragProgress by remember { mutableFloatStateOf(-1f) }

    val loadControl: LoadControl = remember(config.bufferConfig) {
        DefaultLoadControl.Builder()
            .setBufferDurationsMs(
                config.bufferConfig.minBufferMs,
                config.bufferConfig.maxBufferMs,
                config.bufferConfig.playbackBufferMs,
                config.bufferConfig.rebufferMs
            )
            .build()
    }

    val exoPlayer = remember(videoUrl, config) {
        val mediaItemBuilder = MediaItem.Builder()
            .setUri(videoUrl)

        config.drmConfig?.let { drm ->
            val drmBuilder = MediaItem.DrmConfiguration.Builder(config.drmSchemeUuid)
                .setLicenseUri(drm.licenseUrl)
            if (drm.requestHeaders.isNotEmpty()) {
                drmBuilder.setLicenseRequestHeaders(drm.requestHeaders)
            }
            mediaItemBuilder.setDrmConfiguration(drmBuilder.build())
        }

        ExoPlayer.Builder(context)
            .setLoadControl(loadControl)
            .build().apply {
                val mediaItem = mediaItemBuilder.build()
                setMediaItem(mediaItem)
                repeatMode = if (config.isLooping) Player.REPEAT_MODE_ONE else Player.REPEAT_MODE_OFF
                setSeekParameters(if (config.seekClosestSync) SeekParameters.CLOSEST_SYNC else SeekParameters.DEFAULT)
                addListener(object : Player.Listener {
                    override fun onPlaybackStateChanged(state: Int) {
                        when (state) {
                            Player.STATE_BUFFERING -> {
                                isBuffering = true
                                config.onBufferStateChanged(true)
                            }

                            Player.STATE_READY -> {
                                isVideoReady = true
                                isBuffering = false
                                config.onBufferStateChanged(false)
                            }

                            Player.STATE_ENDED, Player.STATE_IDLE -> {
                                isBuffering = false
                                config.onBufferStateChanged(false)
                            }
                        }
                    }

                    override fun onPlayerError(error: PlaybackException) {
                        config.onError(error)
                    }
                })
            }
    }

    val assetManager = context.assets
    val thumbnailList = remember {
        List(10) { index ->
            val imageName = "thumbnail${String.format("%03d", index)}.jpg"
            try {
                assetManager.open(imageName).use { input ->
                    BitmapFactory.decodeStream(input)
                        ?: BitmapFactory.decodeResource(context.resources, ResourceR.drawable.placeholder)
                }
            } catch (e: IOException) {
                DebugLog("Thumbnail load error: $imageName ${e.message}")
                BitmapFactory.decodeResource(context.resources, ResourceR.drawable.placeholder)
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    LaunchedEffect(videoUrl, config) {
        exoPlayer.prepare()
    }

    LaunchedEffect(isMute) {
        exoPlayer.volume = if (isMute) 0f else 1f
    }

    LaunchedEffect(config.playbackSpeed) {
        exoPlayer.playbackParameters = PlaybackParameters(config.playbackSpeed)
    }

    LaunchedEffect(isAutoPlay) {
        exoPlayer.playWhenReady = isAutoPlay
        if (isAutoPlay) exoPlayer.play() else exoPlayer.pause()
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> exoPlayer.pause()
                Lifecycle.Event.ON_DESTROY -> {
                    exoPlayer.stop()
                    exoPlayer.release()
                }

                else -> Unit
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    LaunchedEffect(exoPlayer) {
        while (true) {
            currentPosition = exoPlayer.currentPosition
            delay(300L)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
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
                visible = !isVideoReady,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                IGImage(
                    modifier = Modifier.fillMaxSize(),
                    model = thumbnailsUrl,
                    contentDescription = stringResource(id = ResourceR.string.content_description_thumbnail),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(ResourceR.drawable.placeholder)
                )
            }
        } else {
            IGImage(
                modifier = Modifier.fillMaxSize(),
                model = thumbnailsUrl,
                contentDescription = stringResource(id = ResourceR.string.content_description_thumbnail),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(ResourceR.drawable.placeholder)
            )
        }

        if (isBuffering && isVideoReady) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = LocalColors.current.white)
            }
        }

        if (isShowProcessBar) {
            var barWidthPx by remember { mutableFloatStateOf(0f) }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .align(Alignment.BottomCenter)
                        .onSizeChanged { barWidthPx = it.width.toFloat() }
                        .pointerInput(barWidthPx) {
                            if (barWidthPx == 0f) return@pointerInput

                            detectHorizontalDragGestures(
                                onDragStart = { offset ->
                                    val ratio = (offset.x / barWidthPx).coerceIn(0f, 1f)
                                    dragProgress = ratio
                                },
                                onHorizontalDrag = { change, dragAmount ->
                                    change.consume()
                                    dragProgress = (dragProgress + dragAmount / barWidthPx).coerceIn(0f, 1f)
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
                    val denominator = exoPlayer.duration.takeIf { it > 0 } ?: 1L
                    val progress = if (dragProgress >= 0f) dragProgress else currentPosition / denominator.toFloat()

                    LinearProgressIndicator(
                        progress = { progress.coerceIn(0f, 1f) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp),
                        color = LocalColors.current.red,
                        trackColor = LocalColors.current.darkGray,
                    )
                }

                if (dragProgress >= 0f && exoPlayer.duration > 0 && barWidthPx > 0f) {
                    val previewTimeSec = ((exoPlayer.duration * dragProgress) / 1000).toInt()
                    val safeIndex = previewTimeSec.coerceIn(0, thumbnailList.lastIndex)
                    val previewBitmap = thumbnailList[safeIndex]

                    Box(
                        modifier = Modifier
                            .offset {
                                IntOffset(
                                    (dragProgress * barWidthPx).toInt() - 80,
                                    (-8).dpToPixel()
                                )
                            }
                            .size(160.dp, 90.dp)
                            .background(LocalColors.current.black, RoundedCornerShape(8.dp))
                            .border(1.dp, LocalColors.current.white, RoundedCornerShape(8.dp))
                            .align(Alignment.TopStart)
                    ) {
                        IGImage(
                            model = previewBitmap,
                            contentDescription = stringResource(id = ResourceR.string.content_description_thumbnail_preview),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

