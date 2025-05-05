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
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.IntOffset
import androidx.media3.common.util.Log
import com.example.utils.extension.dpToPixel
import com.example.utils.log.DebugLog
import java.io.IOException


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
    val assetManager = context.assets

    val thumbnailList = remember {
        List(10) { index ->
            val imageName = "thumbnail${String.format("%03d", index)}.jpg"
            try {
                val inputStream = assetManager.open(imageName)
                BitmapFactory.decodeStream(inputStream) ?: run {
                    // 기본 이미지 반환
                    BitmapFactory.decodeResource(context.resources, ResourceR.drawable.placeholder)
                }
            } catch (e: IOException) {
                // 이미지 파일을 찾을 수 없거나 다른 오류 발생 시 로그를 출력하고 기본 이미지를 반환
                Log.e("ThumbnailError", "Error loading image: $imageName", e)
                BitmapFactory.decodeResource(context.resources, ResourceR.drawable.placeholder)
            }
        }
    }

    DisposableEffect(Unit) {
        DebugLog("thumbnailList : ${thumbnailList.first()}")
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
        if (isShowProcessBar) {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp) // 썸네일 띄울 공간 포함
                    .align(Alignment.BottomCenter)
            ) {
                val barWidth = constraints.maxWidth.toFloat()

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp) // 프로그레스 바 높이
                        .align(Alignment.BottomCenter)
                        .pointerInput(Unit) {
                            detectHorizontalDragGestures(
                                onDragStart = { offset ->
                                    val ratio = (offset.x / barWidth).coerceIn(0f, 1f)
                                    dragProgress = ratio
                                },
                                onHorizontalDrag = { change, dragAmount ->
                                    change.consume()
                                    dragProgress = (dragProgress + dragAmount / barWidth).coerceIn(0f, 1f)
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
                            .height(8.dp), // 프로그레스 바 높이
                        color = LocalColors.current.red,
                        trackColor = LocalColors.current.darkGray,
                    )
                }

                // 썸네일 프리뷰
                if (dragProgress >= 0f && exoPlayer.duration > 0) {
                    val previewTimeSec = ((exoPlayer.duration * dragProgress) / 1000).toInt()
                    val safeIndex = previewTimeSec.coerceIn(0, thumbnailList.lastIndex)
                    val previewUrl = thumbnailList[safeIndex]

                    Box(
                        modifier = Modifier
                            .offset {
                                IntOffset(
                                    (dragProgress * barWidth).toInt() - 80, // center align
                                    (-8).dpToPixel() // 썸네일을 프로그레스 바 위에 8dp 마진을 주어 띄움
                                )
                            }
                            .size(160.dp, 90.dp)
                            .background(LocalColors.current.black, RoundedCornerShape(8.dp))
                            .border(1.dp, LocalColors.current.white, RoundedCornerShape(8.dp))
                            .align(Alignment.TopStart)
                    ) {
                        AsyncImage(
                            model = previewUrl,
                            contentDescription = "Thumbnail Preview",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }

}