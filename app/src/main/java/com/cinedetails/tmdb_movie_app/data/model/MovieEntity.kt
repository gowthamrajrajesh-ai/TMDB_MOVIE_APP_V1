package com.cinedetails.tmdb_movie_app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Movies")
data class MovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val isfav: Boolean=false,
    val posterpath: String?,
    val overview: String,
    val releasedate: String?,
    val voteaverge: Double,
    val popularity: Double,
    val originalLanguage: String,
    val voteCount: String,
    val totalpages: Long
    )
