package com.cinedetails.tmdb_movie_app.ui.details

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.cinedetails.tmdb_movie_app.R
import com.cinedetails.tmdb_movie_app.ui.videos.MovieVideoModel
import com.cinedetails.tmdb_movie_app.utli.Contants

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun moviedetails(viewModel: MovieDetailsModel= hiltViewModel(), movieId: Int){

    val moviedetails by viewModel.moviesdetails.collectAsState()
     LaunchedEffect(movieId) {
        viewModel.getmoviedetails(movieId)
     }

    val isFav by viewModel.isfav.collectAsState()

    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background), horizontalAlignment = Alignment.Start) {
        if (moviedetails==null){
            Box(
                  modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
        }

        else {
            val movies = moviedetails
                  Log.e("movies",movies.toString())
                   AsyncImage(
                    model = Contants.Image_URL + movies?.posterpath,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(3f/4f)
,
                    contentScale = ContentScale.Crop
                )

                Column(modifier = Modifier.padding(16.dp).verticalScroll(rememberScrollState()).background(MaterialTheme.colorScheme.background)) {

                    Row(Modifier.fillMaxWidth(),Arrangement.Start) {
                        Text(
                            movies?.title?:"no title",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground)

                        Spacer(modifier = Modifier.width(10.dp))

                        Row(Modifier.fillMaxWidth(),Arrangement.End) {
                            IconButton(onClick = {
                                 viewModel.toggleFavourite()

                            }) {

                                /*                                if (movies?.isfav?:false){
                                    Image(painter = painterResource(R.drawable.favourite),
                                    contentDescription = "favmovies", alignment = Alignment.Center,
                                    modifier = Modifier.size(20.dp))
                                }
                                else {
                                    Image(
                                        painterResource(R.drawable.nofavourite),
                                            "favmovies",
                                            Modifier.size(20.dp),
                                            Alignment.Center
                                        )

                                }*/


                                if (movies==null){
                                    CircularProgressIndicator()
                                }


                            else {
/*                                    Icon(
                                        painter = painterResource(
                                            if (isFav) {
                                                R.drawable.favourite
                                            } else {
                                                R.drawable.nofavourite
                                            }
                                        ), contentDescription = "favourite",
                                        modifier = Modifier.background(MaterialTheme.colorScheme.background)
                                    )

                                    */
                                Box(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .clip(CircleShape)
                                            .background(MaterialTheme.colorScheme.surfaceVariant),
                                        contentAlignment = Alignment.Center
                                    )
                                {
                                        Icon(
                                            painter = painterResource(
                                                if (isFav) R.drawable.favourite
                                                else R.drawable.nofavourite
                                            ),
                                            contentDescription = "favourite",
                                            tint = if (isFav)
                                                MaterialTheme.colorScheme.primary
                                            else
                                                MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                            }
                            }
                        }

                    }

                    Spacer(Modifier.height(8.dp))
                    MovieInfo("overview", "${movies?.overview}")
                    MovieInfo("VoteCount", "${movies?.voteCount} min")
                    MovieInfo("Release", movies?.releasedate?:"no")
                    MovieInfo("Rating", movies?.voteaverge.toString())
                    MovieInfo("Language", movies?.originalLanguage?:"no langauage")
                    MovieInfo("Popularity", "$${movies?.popularity}")
                    showvideo(movieId = movieId)

                }
            }
        }
    }



@Composable
private fun MovieInfo(label: String, value: String) {
    Row(modifier = Modifier.padding(vertical = 4.dp).background(MaterialTheme.colorScheme.background)) {
        Text(
            text = "$label: ",
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(text = value, color = MaterialTheme.colorScheme.onBackground)
    }
}

@Composable
private fun showvideo(videoModel: MovieVideoModel=hiltViewModel(),movieId: Int){
    val movietrailer by videoModel.movievideo.collectAsState()
    val context= LocalContext.current
    val infiniteTransition = rememberInfiniteTransition(label = "blink")

    val alpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 800
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )

    LaunchedEffect(movieId) {
        videoModel.loadvideos(movieId)
    }

    if (movietrailer.trailerKey==null){
        Log.e("no trailerkey",movietrailer.trailerKey.toString())
         Box(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background), contentAlignment = Alignment.Center){
            Text("No Trailer available",
                modifier = Modifier.align(alignment = Alignment.Center).alpha(alpha),
                color = MaterialTheme.colorScheme.onBackground)
        }
    }

    else
    {
        Column(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
             movietrailer.trailerKey?.let { key ->
                 val intent = Intent(
                     Intent.ACTION_VIEW,
                     Uri.parse("https://www.youtube.com/watch?v=$key"))
                 context.startActivity(intent) }

         }) {
                 Text("Click here")}
        }

    }
}




