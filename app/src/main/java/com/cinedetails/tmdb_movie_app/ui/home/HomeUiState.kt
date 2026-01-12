package com.cinedetails.tmdb_movie_app.ui.home

import com.cinedetails.tmdb_movie_app.data.model.AllMovies
import com.cinedetails.tmdb_movie_app.data.model.Result

data class HomeUiState(
    val isLoading: Boolean = false,
    val movies: List<Result> = emptyList(),
    val error: String? = null
)
