package com.cinedetails.tmdb_movie_app.data.remote

import com.cinedetails.tmdb_movie_app.data.model.AllMovies
import com.cinedetails.tmdb_movie_app.data.model.MovieDetails
import com.cinedetails.tmdb_movie_app.data.model.MovieVideo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

@GET("movie/popular?")
suspend fun getpopularmovies(
    @Query("page") page: Int

): AllMovies


@GET("movie/top_rated")
suspend fun gettopratedmovies(
    @Query ("page") page: Int
): AllMovies


@GET("movie/{movie_id}?")
suspend fun getmoviedetails(
    @Path ("movie_id") movieid: Int
 ): MovieDetails

@GET("movie/{movie_id}/videos?")
    suspend fun  getmovievideo(
        @Path("movie_id") video: Int
    ): MovieVideo
}


