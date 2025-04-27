package com.example.ui.component.video

import android.provider.MediaStore.Images.Thumbnails
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.OptIn
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import coil.compose.AsyncImage
import com.example.resource.R as ResourceR


@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(
    thumbnailsUrl: String,
    videoUrl: String,
    isAutoPlay: Boolean = true,
    isMute: Boolean = true,
) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val isVideoReady = remember { mutableStateOf(false) }

    val exoPlayer = remember(videoUrl) {
        ExoPlayer.Builder(context).build().apply {
            repeatMode = Player.REPEAT_MODE_ONE
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

}