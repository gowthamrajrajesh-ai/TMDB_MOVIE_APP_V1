package com.cinedetails.tmdb_movie_app.utli

sealed class UiState<out T>{

    object loading: UiState<Nothing>()

    data class success<T>(val data:T) : UiState<T>()

    data class  fail(val message: String) : UiState<Nothing>()
}