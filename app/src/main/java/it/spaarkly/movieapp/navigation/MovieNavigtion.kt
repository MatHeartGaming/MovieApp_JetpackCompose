package it.spaarkly.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name) {
            //Here we pass where this should lead us to

        }
    }
}