package com.cinedetails.tmdb_movie_app.data.theme

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ThemeRepositoryImpl @Inject constructor(
    private val preferences: ThemePreferences
) : ThemeRepository {

    override val themeMode: Flow<ThemeMode> = preferences.themeMode

    override suspend fun setThemeMode(mode: ThemeMode) {
        preferences.setThemeMode(mode)
    }
}