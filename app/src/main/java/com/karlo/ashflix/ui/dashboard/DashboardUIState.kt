package com.karlo.ashflix.ui.dashboard

import com.karlo.ashflix.model.data.movie.Movie

data class DashboardUIState(
    var trendingMovies: List<Movie> = emptyList()
) {
    companion object {
        fun preview(): DashboardUIState {
            return DashboardUIState(
                trendingMovies = listOf(
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie("")
                )
            )
        }
    }
}
