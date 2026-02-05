package com.cinedetails.tmdb_movie_app.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_movies")
data class FavouriteMovieEntity(
@PrimaryKey val id: Int,
    val title: String,
    val posterpath: String,
    val rating: Double
)
