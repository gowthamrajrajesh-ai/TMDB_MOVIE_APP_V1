package com.cinedetails.tmdb_movie_app.ui.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.cinedetails.tmdb_movie_app.R


@Composable
fun Favouritescreen(navController: NavController,Favviewmodel: Favouriteviewmodel= hiltViewModel()) {

    val favmovie by Favviewmodel.favourites.collectAsState()
    val lottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.nothing))

    if (favmovie.isEmpty() || favmovie==null) {

        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

            Box(contentAlignment = Alignment.Center) {

                LottieAnimation(
                    composition = lottieComposition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.size(280.dp)
                )

            }

            Spacer(modifier = Modifier.height(18.dp))
            Text("no fav is at all", fontSize = 22.sp, textAlign = TextAlign.Center)

        }
    }


    else {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(Modifier.height(50.dp))
                Column(
                        modifier = Modifier.padding(8.dp).fillMaxWidth(),
                        verticalArrangement = Arrangement .Center,
                         Alignment.CenterHorizontally
                    ) {
                        Text(text = "Your Favourite Movies", fontSize = 22.sp, textAlign = TextAlign.Center)
                    }

                Row(Modifier.fillMaxWidth().padding(16.dp)) {
                    LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(items = favmovie, key = {it.id}) { movie ->
                            FavMovieCard(movie, onremoveclick = {
                                Favviewmodel.removeFavourite(movie.id)
                            })
                        }
                    }
                }

            }
        }
    }
