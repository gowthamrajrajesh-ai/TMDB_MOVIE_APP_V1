package com.cinedetails.tmdb_movie_app.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description


@OptIn(ExperimentalCoroutinesApi::class)
class MainDispatcherRule(
    private val dispatcher:TestDispatcher = UnconfinedTestDispatcher() ):TestWatcher() {


    override fun starting(description: Description){
        Dispatchers.setMain(description)

    }


    override fun finished(description: Description){
        Dispatchers.resetMain()
    }


}