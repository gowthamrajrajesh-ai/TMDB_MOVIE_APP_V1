package com.cinedetails.tmdb_movie_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.cinedetails.tmdb_movie_app.ui.themeui.MyAppTheme
import com.cinedetails.tmdb_movie_app.ui.themeui.ThemeViewModel
import com.cinedetails.tmdb_movie_app.utli.navigation.Navhostroutes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeViewModel: ThemeViewModel = hiltViewModel()
            val themeMode by themeViewModel.themeMode.collectAsState()
            MyAppTheme(themeMode = themeMode) {
                Navhostroutes()
            }
        }
    }
}


