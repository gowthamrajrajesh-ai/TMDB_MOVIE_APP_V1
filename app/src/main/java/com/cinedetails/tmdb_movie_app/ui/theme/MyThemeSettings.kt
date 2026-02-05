package com.cinedetails.tmdb_movie_app.ui.theme

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cinedetails.tmdb_movie_app.data.theme.ThemeMode
import com.cinedetails.tmdb_movie_app.ui.themeui.ThemeViewModel
import com.cinedetails.tmdb_movie_app.utli.navigation.NavScreen

@Composable
fun themesettings(navController: NavController) {

    val themeViewModel: ThemeViewModel= hiltViewModel()

        val themeMode by themeViewModel.themeMode.collectAsState()

    val context = LocalContext.current
    Column (
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Turn on the mode that u want", modifier = Modifier.fillMaxWidth(), fontSize = 20.sp)
        Spacer(modifier = Modifier.height(18.dp))


        ThemeButton(
            text = "Light Mode",
            selected = themeMode == ThemeMode.LIGHT
        ) {
            themeViewModel.setTheme(ThemeMode.LIGHT)
        }


        ThemeButton(
            text = "Dark Mode",
            selected = themeMode == ThemeMode.DARK
        ) {
            themeViewModel.setTheme(ThemeMode.DARK)
        }


        ThemeButton(
            text = "System Default",
            selected = themeMode == ThemeMode.SYSTEM
        ) {
            themeViewModel.setTheme(ThemeMode.SYSTEM)
        }


        Spacer(Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
            Log.d("beforeclicking","testing")
            TextButton(onClick = {
                navController.navigate(NavScreen.home.route) {
//                    popUpTo(NavScreen.darktheme.route) { inclusive = true }
                }


            }) {
                Text("Processed to Movielist!!")
            }

        }

        Spacer(modifier = Modifier.height(18.dp))
        val emoji = "🍿😎"
        Button(onClick = {
     navController.navigate(NavScreen.favmovies.route){
       popUpTo(NavScreen.home.route) {inclusive =true}
     }
        })
        {
            Text("get your fav movies  ${emoji}")
        }


    }



}


//@Preview
//@Composable
//fun mypreview(){
//    themesettings()
//
//}

@Composable
fun ThemeButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected)
                MaterialTheme.colorScheme.primary
            else
                MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Text(text)
    }
}
