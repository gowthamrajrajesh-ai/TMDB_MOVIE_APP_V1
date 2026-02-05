package com.cinedetails.tmdb_movie_app.utli.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cinedetails.tmdb_movie_app.ui.details.moviedetails
import com.cinedetails.tmdb_movie_app.ui.favourite.Favouritescreen
import com.cinedetails.tmdb_movie_app.ui.home.HomeScreen
import com.cinedetails.tmdb_movie_app.ui.splash.SplashScreen
import com.cinedetails.tmdb_movie_app.ui.theme.themesettings


@Composable
fun Navhostroutes(){
    val navroute= rememberNavController()
    NavHost(
        navController = navroute,
        startDestination = NavScreen.splash.route
    ) {
        composable(NavScreen.splash.route) {
            SplashScreen(navroute)
        }

        composable(NavScreen.darktheme.route) {
           themesettings (navroute)
        }

        composable(NavScreen.home.route){
            HomeScreen( onMovieClick = { id ->
                navroute.navigate(NavScreen.details.passId(id))
            })
        }

        composable(NavScreen.details.route,
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })){
                backStackEntry ->
            val id = backStackEntry.arguments?.getInt("movieId")!!
            moviedetails(movieId = id)
        }

        composable(NavScreen.favmovies.route) {
            Favouritescreen(navroute)
        }
    }
}