package com.karlo.ashflix.ui.view.video

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.karlo.ashflix.R
import com.karlo.ashflix.ui.main.BasePreview


@Composable
fun VideoScreen(modifier: Modifier = Modifier, windowSizeClass: WindowWidthSizeClass) {
    Box(modifier = modifier.fillMaxSize()) {
        Icon(
            painter = painterResource(R.drawable.baseline_play_arrow_24),
            contentDescription = stringResource(R.string.play_video)
        )
    }
}


@Preview
@Composable
private fun Preview() {
    BasePreview {
        VideoScreen(windowSizeClass = WindowWidthSizeClass.Compact)
    }
}