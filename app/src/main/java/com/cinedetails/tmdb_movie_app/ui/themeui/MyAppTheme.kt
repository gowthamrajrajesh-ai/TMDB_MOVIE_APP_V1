package com.cinedetails.tmdb_movie_app.ui.themeui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.cinedetails.tmdb_movie_app.data.theme.ThemeMode
import com.cinedetails.tmdb_movie_app.ui.theme.DarkBackground
import com.cinedetails.tmdb_movie_app.ui.theme.DarkOnBackground
import com.cinedetails.tmdb_movie_app.ui.theme.DarkPrimary
import com.cinedetails.tmdb_movie_app.ui.theme.DarkSurface
import com.cinedetails.tmdb_movie_app.ui.theme.LightBackground
import com.cinedetails.tmdb_movie_app.ui.theme.LightOnBackground
import com.cinedetails.tmdb_movie_app.ui.theme.LightPrimary
import com.cinedetails.tmdb_movie_app.ui.theme.LightSurface
import com.cinedetails.tmdb_movie_app.ui.theme.Typography

val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    background = LightBackground,
    surface = LightSurface,
    onBackground = LightOnBackground
)

val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    background = DarkBackground,
    surface = DarkSurface,
    onBackground = DarkOnBackground
)


@Composable
fun MyAppTheme(
    themeMode: ThemeMode,
    content: @Composable () -> Unit
) {
    val darkTheme = when (themeMode) {
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
        ThemeMode.DARK -> true
        ThemeMode.LIGHT -> false
    }

    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
