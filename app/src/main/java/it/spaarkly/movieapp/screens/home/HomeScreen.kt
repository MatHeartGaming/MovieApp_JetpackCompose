package it.spaarkly.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import it.spaarkly.movieapp.model.Movie
import it.spaarkly.movieapp.model.getMovies
import it.spaarkly.movieapp.navigation.MovieScreens
import it.spaarkly.movieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController : NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Magenta,
            elevation = 5.dp,) {
            Text("Movies")
        }
    }) {it
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    movieList: List<Movie> = getMovies(), navController: NavController
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background,
    ) {
        Column(modifier = Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp)) {
            LazyColumn{
                items(movieList){ movie ->
                    MovieRow(movie = movie) {
                        Log.d("Tap", "MainContent: $it")
                        navController.navigate(route = MovieScreens.DetailScreen.name + "/${movie.id}")
                    }
                }
            }
        }
    }

}