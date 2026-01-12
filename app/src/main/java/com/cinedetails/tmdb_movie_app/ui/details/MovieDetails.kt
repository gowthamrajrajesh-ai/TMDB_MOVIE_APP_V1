package com.cinedetails.tmdb_movie_app.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.cinedetails.tmdb_movie_app.utli.Contants
import com.cinedetails.tmdb_movie_app.utli.ShimmerEffect

@Composable
fun moviedetails(viewModel: MovieDetailsModel= hiltViewModel(), movieId: Int){

    val moviedetails by viewModel.moviesdetails.collectAsState()


    LaunchedEffect(movieId) {
        viewModel.getmoviedetails(movieId)
    }

    Column(modifier = Modifier.fillMaxSize().background(ShimmerEffect()), horizontalAlignment = Alignment.Start) {
        when{
            moviedetails.isLoading && moviedetails.isdetails.isEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            moviedetails.error != null && moviedetails.isdetails.isEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(moviedetails.error!!)
                }
            }


            else-> {
                val movies= moviedetails.isdetails
                AsyncImage(
                    model = Contants.Image_URL + movies[0].posterPath,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(3f/4f),
                    contentScale = ContentScale.Crop
                )

                Column(modifier = Modifier.padding(16.dp).verticalScroll(rememberScrollState()),) {

                    Text(
                        movies[0].title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(8.dp))
                    MovieInfo("overview", "${movies[0].overview}")
                    MovieInfo("Runtime", "${movies[0].runtime} min")
                    MovieInfo("Release", movies[0].releaseDate)
                    MovieInfo("Rating", movies[0].voteAverage.toString())
                    MovieInfo("Language", movies[0].originalLanguage)
                    MovieInfo("Budget", "$${movies[0].budget}")
                    MovieInfo("Popularity", "$${movies[0].popularity}")
                    MovieInfo("spokenLanguages", "${movies[0].spokenLanguages}")
                }

            }
        }
    }
  }


@Composable
private fun MovieInfo(label: String, value: String) {
    Row(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = "$label: ",
            fontWeight = FontWeight.SemiBold
        )
        Text(text = value)
    }
}