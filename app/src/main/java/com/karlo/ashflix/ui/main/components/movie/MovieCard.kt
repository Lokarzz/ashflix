package com.karlo.ashflix.ui.main.components.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.karlo.ashflix.R
import com.karlo.ashflix.model.data.movie.Movie
import com.karlo.ashflix.ui.main.BasePreview


@Composable
fun MovieCard(modifier: Modifier = Modifier, movie: Movie) {
    ElevatedCard(modifier = modifier.aspectRatio(9f / 16f)) {
        Box(modifier = Modifier) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.ashflix),
                contentDescription = stringResource(R.string.background_logo),
                contentScale = ContentScale.Crop
            )
        }
    }
}


@Preview
@Composable
private fun Preview() {
    BasePreview {
        MovieCard(movie = Movie(imageUrl = ""))
    }
}