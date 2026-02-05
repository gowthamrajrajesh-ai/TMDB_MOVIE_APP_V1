package com.cinedetails.tmdb_movie_app.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.cinedetails.tmdb_movie_app.BuildConfig
import com.cinedetails.tmdb_movie_app.R
import com.cinedetails.tmdb_movie_app.utli.navigation.NavScreen
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    val isDark = MaterialTheme.colorScheme.background.luminance() < 0.5f
    val gradientBackground = Brush.horizontalGradient(
        colors = if (isDark) {
            listOf(
                Color(0xFF0D253F),
                Color(0xFF1C3A5F)
            )
        }
        else {
            listOf(
                Color(0xFFED765E),
                Color(0xFFFEA858)
            )
        }
    )

    val lottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.loading))
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground)
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    )
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(R.drawable.movielogo),
                contentDescription = null,
                modifier = Modifier.size(350.dp).background(MaterialTheme.colorScheme.background)
            )

            Spacer(modifier = Modifier.height(6.dp))

            LottieAnimation(
                composition = lottieComposition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))
        }

        Text(
            text = "version: ${BuildConfig.VERSION_NAME}",
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )

    }


    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(NavScreen.darktheme.route){
            popUpTo(NavScreen.splash.route) { inclusive = true }
        }
    }

}

