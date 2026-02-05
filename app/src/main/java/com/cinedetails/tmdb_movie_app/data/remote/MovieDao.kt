package com.cinedetails.tmdb_movie_app.data.remote

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import com.cinedetails.tmdb_movie_app.data.model.FavouriteMovieEntity
import com.cinedetails.tmdb_movie_app.data.model.MovieEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertmovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM Movies")
    suspend fun getmovies(): List<MovieEntity>

    @Query("SELECT * FROM Movies WHERE id = :movieid")
    suspend fun getmoviebuyid(movieid: Int): MovieEntity?

    @Query("UPDATE Movies SET isfav = :isfav WHERE id = :movieid")
    suspend fun updatemovies(isfav: Boolean,movieid: Int)


    @Query("SELECT * FROM Movies WHERE isfav = 1")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>
}

@Database(
    entities = [MovieEntity::class,FavouriteMovieEntity::class],
    version = 2,
    exportSchema = false

)
abstract class AppDataBase: RoomDatabase(){
    abstract fun moviedao(): MovieDao
    abstract fun favouritemoviedao(): FavMovieDao
}







