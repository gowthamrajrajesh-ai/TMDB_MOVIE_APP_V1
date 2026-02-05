package com.cinedetails.tmdb_movie_app.data.model

import com.google.gson.annotations.SerializedName

data class MovieVideo(
    val id: Long,
    val results: List<Results>,
    )

data class Results(
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("iso_3166_1")
    val iso31661: String,
    val name: String,
    val key: String,
    val site: String,
    val size: Long,
    val type: String,
    val official: Boolean,
    @SerializedName("published_at")
    val publishedAt: String,
    val id: String,
)
