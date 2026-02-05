package com.cinedetails.tmdb_movie_app.ui.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinedetails.tmdb_movie_app.data.respository.FavouriteRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Favouriteviewmodel @Inject constructor(
    private val FavRespository: FavouriteRespository
): ViewModel() {

    val favourites = FavRespository.getfavmovies()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun favouritelaunch(){
       viewModelScope.launch {
           val favourites = FavRespository.getfavmovies()
               .stateIn(
                   viewModelScope,
                   SharingStarted.WhileSubscribed(5000),
                   emptyList()
               )
       }
    }

    fun removeFavourite(movieId: Int) {
        viewModelScope.launch {
            FavRespository.remove(movieId)
        }
    }
}

