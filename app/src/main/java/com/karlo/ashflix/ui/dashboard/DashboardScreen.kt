package com.karlo.ashflix.ui.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.karlo.ashflix.R
import com.karlo.ashflix.model.data.movie.Movie
import com.karlo.ashflix.ui.main.BasePreview
import com.karlo.ashflix.ui.main.components.movie.MovieCard

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    dashboardViewModel: DashboardViewModel = viewModel()
) {
    val uiState by dashboardViewModel.uiState.collectAsStateWithLifecycle()
    DashboardView(modifier = modifier, uiState = uiState)
}

@Composable
fun DashboardView(modifier: Modifier = Modifier, uiState: DashboardUIState) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            item {
                Movies(movies = uiState.trendingMovies)
            }
        }
    }
}


@Composable
fun Movies(modifier: Modifier = Modifier, movies: List<Movie>) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.padding_medium),
                start = dimensionResource(R.dimen.padding_medium)
            ),
            text = stringResource(R.string.trending_now)
        )
        LazyRow(
            modifier = Modifier,
            contentPadding = PaddingValues(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            items(movies) {
                MovieCard(
                    modifier = Modifier.width(dimensionResource(R.dimen.movie_width)),
                    movie = it
                )
            }
        }
    }

}


@Preview
@Composable
private fun DashboardScreenPreview() {
    val uiState = DashboardUIState.preview()
    BasePreview {
        DashboardView(uiState = uiState)
    }
}

@Preview(device = Devices.TABLET)
@Composable
private fun DashboardScreenPreviewTab() {
    val uiState = DashboardUIState.preview()
    BasePreview {
        DashboardView(uiState = uiState)
    }
}

@Preview(device = Devices.FOLDABLE)
@Composable
private fun DashboardScreenPreviewFold() {
    val uiState = DashboardUIState.preview()
    BasePreview {
        DashboardView(uiState = uiState)
    }
}