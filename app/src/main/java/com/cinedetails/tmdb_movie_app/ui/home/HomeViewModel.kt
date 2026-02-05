package com.cinedetails.tmdb_movie_app.ui.home

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
class HomeViewModel @Inject constructor(
   private val respository: MovieRespository): ViewModel() {
         private val _uiState = MutableStateFlow(HomeUiState())
         val uiState: StateFlow<HomeUiState> = _uiState
         private var currentpage = 1
         private var totalPages = Int.MAX_VALUE

    init {
        getallmovie()
    }

    fun getallmovie() {
        if (_uiState.value.isLoading || currentpage > totalPages) return
         viewModelScope.launch {
             try {
                _uiState.update { it.copy(isLoading=true, error = null) }
                val response = respository.getallmovies(currentpage)
                 _uiState.update {
                     it.copy(
                         movies = (it.movies + response)
                             .distinctBy { movie -> movie.id },
                         isLoading = false
                     )
                 }
                 currentpage++
                 totalPages=response[0].totalpages.toInt()
             }
             catch (e: IOException) {
                _uiState.update { it.copy(isLoading = false, error = "NETWORK ERROR: ${e.message}")}
            }
             catch (e: HttpException){
                _uiState.update { it.copy(isLoading = false, error = "API ERROR : ${e.response}")}
             }
         }
    }

   }






