package it.spaarkly.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.base.R
import coil.compose.AsyncImage
import coil.request.ImageRequest
import it.spaarkly.movieapp.model.Movie
import it.spaarkly.movieapp.model.getMovies
import it.spaarkly.movieapp.navigation.MovieScreens
import it.spaarkly.movieapp.widgets.MovieRow

@Composable
fun DetailsScreen(navController: NavHostController, movieId: String?) {
    val movie = getMovies().filter {
        it.id == movieId
    }.first()
    Scaffold(topBar = {
        TopAppBar(backgroundColor = MaterialTheme.colors.primaryVariant,
        elevation = 5.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })

                Spacer(modifier = Modifier.width(100.dp))

                Text(text = "Movies", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    }) {it
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
            MovieRow(movie = movie)
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            HorizontalScrollableImageView(movie)
        }
    }
}

@Composable
private fun HorizontalScrollableImageView(movie: Movie) {
    LazyRow {
        items(movie.images) { img ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp,
                shape = CircleShape
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://images.mubicdn.net/images/film/1731/cache-100534-1563231667/image-w1280.jpg?size=800x")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_100tb),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    filterQuality = FilterQuality.High,
                    modifier = Modifier.clip(CircleShape)
                )
            }
        }
    }
}