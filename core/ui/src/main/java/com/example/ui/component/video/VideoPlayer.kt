package com.example.ui.component.video

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.example.utils.log.DebugLog

@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(
    videoUrl: String,
    isAutoPlay: Boolean = true,
    isMute: Boolean = true,
    onReadyState: () -> Unit
) {
    DebugLog("VideoPlayer")

    DebugLog("isAutoPlay : ${isAutoPlay}")
    DebugLog("isMute : ${isMute}")

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val exoPlayer = remember(videoUrl) {
        ExoPlayer.Builder(context).build().apply {
            repeatMode = Player.REPEAT_MODE_ONE
            addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(state: Int) {
                    when (state) {
                        Player.STATE_BUFFERING -> {
                            // Log.d("PlayerState", "버퍼링 중")
                        }

                        Player.STATE_READY -> {
                            onReadyState.invoke()
                            // Log.d("PlayerState", "재생 준비 완료")
                        }

                        Player.STATE_ENDED -> {
                            // Log.d("PlayerState", "재생 끝")
                        }

                        Player.STATE_IDLE -> {
                            // Log.d("PlayerState", "플레이어 IDLE")
                        }
                    }
                }

                override fun onIsPlayingChanged(isPlaying: Boolean) {
                    // Log.d("PlayerState", "현재 재생 중인가요? $isPlaying")
                }
            })
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
}