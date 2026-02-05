package com.cinedetails.tmdb_movie_app.data.respository

import com.cinedetails.tmdb_movie_app.data.model.FavouriteMovieEntity
import com.cinedetails.tmdb_movie_app.data.remote.FavMovieDao
import javax.inject.Inject

class FavouriteRespository @Inject constructor(
    private val favMovieDao: FavMovieDao
) {

    fun getfavmovies()=favMovieDao.getallfavmovie()
    suspend fun add(movie: FavouriteMovieEntity)=favMovieDao.insertfav(movie)
    suspend fun remove(movieid:Int)=favMovieDao.delectedid(movieid)
    suspend fun  isfavourite(movieid: Int)=favMovieDao.isfavourite(movieid)
}