package com.cinedetails.tmdb_movie_app.ui.home

import com.cinedetails.tmdb_movie_app.data.model.MovieEntity

data class HomeUiState(
    val isLoading: Boolean = false,
    val movies: List<MovieEntity> = emptyList(),
    val error: String? = null
)
