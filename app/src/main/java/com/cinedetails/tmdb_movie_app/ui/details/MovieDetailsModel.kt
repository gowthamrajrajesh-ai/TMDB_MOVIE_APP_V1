package com.cinedetails.tmdb_movie_app.ui.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinedetails.tmdb_movie_app.data.model.MovieDetails
import com.cinedetails.tmdb_movie_app.data.respository.MovieRespository
import com.cinedetails.tmdb_movie_app.ui.home.HomeUiState
import com.cinedetails.tmdb_movie_app.utli.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsModel @Inject constructor(private val respository: MovieRespository): ViewModel() {
    private val _moviedetails = MutableStateFlow(MovieUiState())
    val moviesdetails: StateFlow<MovieUiState> = _moviedetails
     val  id: Int ?=null
    init {
         getmoviedetails(id?:0)
    }

    fun getmoviedetails(id: Int){
    viewModelScope.launch {

        try {
            _moviedetails.update { it.copy(isLoading = true, error =  null) }
            val response =respository.getmoviedetails(id)

            _moviedetails.update { it.copy(isLoading = false, isdetails = it.isdetails + response) }

            Log.e("_MOVIEDETAILS",response.toString())

        }

        catch (e: Exception){
            Log.e("EXCEPTION",e.message.toString())
            _moviedetails.update { it.copy(isLoading = false, error = "Error: ${e.message}") }
            Log.e("EXCEPTIONLOCAL",e.localizedMessage)
        }

    }
} }