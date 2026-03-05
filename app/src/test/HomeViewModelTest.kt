package com.cinedetails.tmdb_movie_app.test


import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {
    @get:Rule
    val dispatcherRule= MainDispatcherRule()
}


