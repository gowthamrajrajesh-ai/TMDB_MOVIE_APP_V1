package com.cinedetails.tmdb_movie_app.data.respository

import android.util.Log
import com.cinedetails.tmdb_movie_app.data.model.MovieEntity
import com.cinedetails.tmdb_movie_app.data.remote.MovieApi
import com.cinedetails.tmdb_movie_app.data.remote.MovieDao
import javax.inject.Inject

class MovieRespository @Inject constructor (
    private val movieApi: MovieApi,
    private val movieDao: MovieDao
)
{ suspend fun getallmovies(page:Int): List<MovieEntity>{
        return try {
            val response=movieApi.getpopularmovies(page)
            Log.d("Roommyresponse",response.toString())

            val movies = response.results.map { dto ->
                MovieEntity(
                    id = dto.id,
                    title = dto.title,
                    overview = dto.overview,
                    posterpath = dto.posterPath,
                    releasedate = dto.releaseDate,
                    voteaverge = dto.voteAverage,
                    isfav = false,
                    popularity = dto.popularity,
                    originalLanguage = dto.originalLanguage,
                    voteCount = dto.voteCount.toString(),
                    totalpages = response.totalPages
                )
            }
            movieDao.insertmovies(movies)
            movies
        }
           catch (e: Exception) {
            movieDao.getmovies()
        }

    }
    suspend fun  getmoviedetails(id: Int): MovieEntity?{
        return movieDao.getmoviebuyid(id)
    }

    suspend fun  getmovievideos(video: Int)=movieApi.getmovievideo(video)

}