package com.karlo.ashflix.ui.view.video

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.karlo.ashflix.ui.main.BasePreview


@Composable
fun VideoScreen(modifier: Modifier = Modifier, windowSizeClass: WindowWidthSizeClass) {
    Box(modifier = modifier.fillMaxSize()) {
//        Icon(
//            modifier = Modifier.align(Alignment.TopEnd),
//            painter = painterResource(R.drawable.baseline_play_arrow_24),
//            contentDescription = stringResource(R.string.play_video)
//        )
        val driveUrl =
            "https://drive.google.com/file/d/1BxSrCP1S4z0PLYNXahpDjL11_6_TPRn0/view?usp=drive_link"
        val bunnyUrl =
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
//        VideoPlayer(
//            modifier = Modifier.fillMaxSize(),
//            videoUrl = driveUrl
//        )

    }
}

@Composable
fun VideoPlayer(modifier: Modifier = Modifier, videoUrl: String) {
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build()
    }

    DisposableEffect(videoUrl) {
        exoPlayer.setMediaItem(MediaItem.fromUri(videoUrl))
        exoPlayer.prepare()
        onDispose {
            exoPlayer.release()
        }
    }
    AndroidView(factory = { ctx ->
        PlayerView(ctx).apply {
            player = exoPlayer
            useController = true
        }
    }, modifier = modifier)
}

@Preview
@Composable
private fun Preview() {
    BasePreview {
        VideoScreen(windowSizeClass = WindowWidthSizeClass.Compact)
    }
}