package com.cinedetails.tmdb_movie_app.data.respository

import com.cinedetails.tmdb_movie_app.data.remote.MovieApi
import javax.inject.Inject

class MovieRespository @Inject constructor (
    private val movieApi: MovieApi


) {
    suspend fun getallmovies(page:Int)= movieApi.getpopularmovies(page)
    suspend fun  getmoviedetails(id: Int)=movieApi.getmoviedetails(id)

}