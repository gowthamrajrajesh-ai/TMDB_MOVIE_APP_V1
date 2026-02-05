package com.cinedetails.tmdb_movie_app.data.theme

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// this line creates datastore
private val Context.dataStore by preferencesDataStore(name = "theme_settings")

class ThemePreferences (private val context: Context) {

companion object {
    val DARK_KEY_MODE = stringPreferencesKey("darkmode")
}

    val themeMode: Flow<ThemeMode> =
        context.dataStore.data.map { prefs ->
            when (prefs[DARK_KEY_MODE]) {
                ThemeMode.DARK.name   -> ThemeMode.DARK
                ThemeMode.LIGHT.name  -> ThemeMode.LIGHT
                else -> ThemeMode.SYSTEM
            }
        }

    suspend fun setThemeMode(mode: ThemeMode) {
        context.dataStore.edit { prefs ->
            prefs[DARK_KEY_MODE] = mode.name
        }
    }
}