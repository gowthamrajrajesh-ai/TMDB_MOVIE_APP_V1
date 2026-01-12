package com.cinedetails.tmdb_movie_app.data.remote

import com.cinedetails.tmdb_movie_app.data.model.AllMovies
import com.cinedetails.tmdb_movie_app.data.model.MovieDetails
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


@GET("movie/{MOVIE_ID}?")
suspend fun getmoviedetails(
    @Path ("MOVIE_ID") movieid: Int
 ): MovieDetails
}