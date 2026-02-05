package com.cinedetails.tmdb_movie_app.ui.splash

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import com.cinedetails.tmdb_movie_app.ui.theme.SplashGradientDarkEnd
import com.cinedetails.tmdb_movie_app.ui.theme.SplashGradientDarkStart
import com.cinedetails.tmdb_movie_app.ui.theme.SplashGradientLightEnd
import com.cinedetails.tmdb_movie_app.ui.theme.SplashGradientLightStart

@Composable
fun splashgradient(): Brush{
    val isDark = isSystemInDarkTheme()
    return if (isDark) {
        Brush.horizontalGradient(
            colors = listOf(
                SplashGradientDarkStart,
                SplashGradientDarkEnd
            )
        )
    } else {
        Brush.horizontalGradient(
            colors = listOf(
                SplashGradientLightStart,
                SplashGradientLightEnd
            )
        )
    }

}