package com.cinedetails.tmdb_movie_app.ui.videos


import com.cinedetails.tmdb_movie_app.data.model.Results

data class MovieVideoUiState(

    val loading: Boolean=false,

    val trailerKey: String? = null,

    val error: String?=null,




)
