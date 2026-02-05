package com.cinedetails.tmdb_movie_app.data.remote

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cinedetails.tmdb_movie_app.data.model.FavouriteMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavMovieDao {

@Query("SELECT * FROM  favourite_movies")
fun getallfavmovie(): Flow<List<FavouriteMovieEntity>>

@Insert(onConflict = OnConflictStrategy.REPLACE )
suspend fun insertfav(movieEntity: FavouriteMovieEntity)

@Query("DELETE FROM favourite_movies WHERE id= :movieid")
suspend fun delectedid(movieid: Int)

@Query("SELECT EXISTS(SELECT 1 FROM favourite_movies WHERE id = :movieid)")
suspend fun isfavourite(movieid: Int): Boolean
}


