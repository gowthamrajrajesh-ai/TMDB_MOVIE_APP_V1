package com.cinedetails.tmdb_movie_app.ui.videos

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.cinedetails.tmdb_movie_app.data.respository.MovieRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MovieVideoModel @Inject constructor(
    private val respository: MovieRespository): ViewModel() {
        private val _movievideo = MutableStateFlow(MovieVideoUiState())
        val movievideo : StateFlow<MovieVideoUiState> = _movievideo

    fun loadvideos(movieId: Int){
        if (movieId <= 0) return
        if (_movievideo.value.loading) return
        viewModelScope.launch {
            try {
                _movievideo.update { it.copy(loading = true, error = null ) }
                    val response=  respository.getmovievideos(movieId)
                    val trailerKey = response.results.firstOrNull {
                        it.site == "YouTube" && it.type == "Trailer"
                    }?.key
                Log.d("trailerKey",trailerKey.toString())
                    _movievideo.update { it.copy(loading = false, trailerKey = trailerKey )}
                    Log.e("MovieVideoRespone",response.toString())

                }

               catch (e: HttpException){
                   _movievideo.update {it.copy(loading = false, error = "ERROR: ${e.message}")}
                   Log.d("HttpException",e.message.toString())
                   Log.d("HttpException",e.localizedMessage.toString())
               }

            catch (e:IOException){
                _movievideo.update { it.copy(loading = false, error = "ERROR: ${e.message}") }
                Log.d("IOException",e.message.toString())
                Log.d("IOException",e.localizedMessage.toString())
            }
        } }
    }