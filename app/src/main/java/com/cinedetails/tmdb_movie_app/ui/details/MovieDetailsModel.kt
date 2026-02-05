package com.cinedetails.tmdb_movie_app.ui.details

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinedetails.tmdb_movie_app.data.model.FavouriteMovieEntity
import com.cinedetails.tmdb_movie_app.data.model.MovieEntity
import com.cinedetails.tmdb_movie_app.data.respository.FavouriteRespository
import com.cinedetails.tmdb_movie_app.data.respository.MovieRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MovieDetailsModel @Inject constructor(private val respository: MovieRespository,
    private val favouriteRespository: FavouriteRespository

  ): ViewModel() {
    private val _moviedetails = MutableStateFlow<MovieEntity?>(null)
    val moviesdetails: StateFlow<MovieEntity?> = _moviedetails
     val  id: Int ?=null

    val _isfav= MutableStateFlow(false)
    val isfav=_isfav.asStateFlow()

    /*  init {
         getmoviedetails(id?:0)
    }*/

    var isloading: Boolean=false
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getmoviedetails(id: Int){
    viewModelScope.launch {
        isloading=true
        try {
            val movie=respository.getmoviedetails(id)
            isloading=false
            _moviedetails.value=respository.getmoviedetails(id)
            _moviedetails.value=movie

            _isfav.value = favouriteRespository.isfavourite(id)
            Log.e("_MOVIEDETAILS",_moviedetails.value.toString())

        }

        catch (e:IOException){
            isloading=false
            Log.e("IOException",e.message.toString())
            Log.e("IOExceptionLOCAL",e.localizedMessage)
        }

        catch (e: HttpException){
            isloading=false
            Log.e("HttpException",e.message.toString())
            Log.e("HttpExceptionLOCAL",e.localizedMessage)
        }

    }
}


    fun toggleFavourite() {
        val movie = _moviedetails.value ?: return
        viewModelScope.launch {
            if (_isfav.value) {
                favouriteRespository.remove(movie.id)
                Log.e("movietoggleremove","the movie is removed")
            } else {
                favouriteRespository.add(
                    FavouriteMovieEntity(
                        id = movie.id,
                        title = movie.title,
                        posterpath = movie.posterpath.toString(),
                        rating = movie.voteaverge
                    )
                )
                Log.e("movie else ","the movie is removed not")

            }
            _isfav.value = !_isfav.value

        }
    }



/*
    fun togglebutton(){
        val current=_moviedetails.value ?: return
        viewModelScope.launch {
            respository.toggleFavorite(movieId = current.id, isFav = !current.isfav)
            getmoviedetails(current.id)
        }
    }
*/

}