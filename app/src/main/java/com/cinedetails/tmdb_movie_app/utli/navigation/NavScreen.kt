package com.cinedetails.tmdb_movie_app.utli.navigation

sealed class NavScreen(val route : String) {
    object splash: NavScreen("splash")
    object favmovies: NavScreen("favmovies")
    object darktheme: NavScreen("darkmode")
    object home: NavScreen("home")
    object details: NavScreen("details/{movieId}"){
        fun passId(id: Int) = "details/$id"
    }
}