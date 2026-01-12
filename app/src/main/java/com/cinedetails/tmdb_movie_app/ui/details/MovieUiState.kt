package com.cinedetails.tmdb_movie_app.ui.details

import com.cinedetails.tmdb_movie_app.data.model.MovieDetails

data class MovieUiState(
    val isLoading: Boolean = false,
    val isdetails: List<MovieDetails> = emptyList(),
    val error: String ?  = null
)
