package com.cinedetails.tmdb_movie_app.ui.themeui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinedetails.tmdb_movie_app.data.theme.ThemeMode
import com.cinedetails.tmdb_movie_app.data.theme.ThemeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(private val repository: ThemeRepository): ViewModel() {
    val themeMode = repository.themeMode
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            ThemeMode.SYSTEM
        )

    fun setTheme(mode: ThemeMode) {
        viewModelScope.launch {
            repository.setThemeMode(mode)
        }
    }
}