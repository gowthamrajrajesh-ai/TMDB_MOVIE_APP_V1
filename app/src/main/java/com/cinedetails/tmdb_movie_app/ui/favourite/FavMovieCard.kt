package com.cinedetails.tmdb_movie_app.ui.favourite

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.cinedetails.tmdb_movie_app.data.model.FavouriteMovieEntity
import com.cinedetails.tmdb_movie_app.utli.AnimatedFavIcon
import com.cinedetails.tmdb_movie_app.utli.Contants
import kotlinx.coroutines.delay

@Composable
fun FavMovieCard(movie: FavouriteMovieEntity,onremoveclick:()-> Unit) {

    var visible: Boolean by remember { mutableStateOf(true) }

    val context= LocalContext.current

    AnimatedVisibility(
        visible = visible,
                exit = shrinkVertically(animationSpec = tween(300))+
                fadeOut(animationSpec = tween(300))
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .aspectRatio(2f / 3f),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(6.dp)


        ) {
            Column {
                AsyncImage(
                    model = Contants.Image_URL + movie.posterpath,
                    contentDescription = movie.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )

                Column(modifier = Modifier.padding(8.dp)) {

                    Text(
                        text = movie.title,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(Modifier.height(4.dp))

                    Text("⭐ ${movie.rating}")

                    Spacer(Modifier.height(4.dp))

                    Row(Modifier.fillMaxWidth(), Arrangement.End) {

                        AnimatedFavIcon(onClick = { visible=false },
                            isFav = true
                        )
                    }
                }
            } }
    }


    LaunchedEffect(visible) {
        if (!visible) {
            delay(300)
            onremoveclick()
            Toast.makeText(context, "fav channel is removed successfully", Toast.LENGTH_LONG).show()
        }
    }
}
