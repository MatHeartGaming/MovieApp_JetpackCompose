package it.spaarkly.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import it.spaarkly.movieapp.R
import it.spaarkly.movieapp.model.Movie
import it.spaarkly.movieapp.model.getMovies

@Preview
@Composable
fun MovieRow(movie : Movie = getMovies()[0], onItemClick : (String)-> Unit = {}) {
    val expanded = remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp)
        .clip(RoundedCornerShape(16.dp))
        .clickable {
            onItemClick(movie.title)
        },
        shape = RoundedCornerShape(16.dp),
        elevation = 6.dp) {
        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = CircleShape,
                elevation = 5.dp) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://images.mubicdn.net/images/film/1731/cache-100534-1563231667/image-w1280.jpg?size=800x")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(coil.base.R.drawable.ic_100tb),
                    contentDescription = stringResource(R.string.app_name),
                    contentScale = ContentScale.FillBounds,
                    filterQuality = FilterQuality.High,
                    modifier = Modifier.clip(CircleShape)
                )
            }
            Column(modifier = Modifier
                .padding(4.dp)
                .verticalScroll(rememberScrollState())) {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Genre: ${movie.genre}", style = MaterialTheme.typography.caption)
                Text(text = "Genre: ${movie.year}", style = MaterialTheme.typography.caption)

                //Hidden stuff
                AnimatedVisibility(visible = expanded.value) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                color = Color.DarkGray,
                                fontSize = 13.sp),
                            ){
                                append("Plot: ")
                            }
                            withStyle(style = SpanStyle(
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                            fontWeight = FontWeight.Light)
                            ){
                                append(movie.plot)
                            }
                        }, modifier = Modifier.padding(6.dp))
                        Divider()
                        Text("Director: ${movie.director}", style = MaterialTheme.typography.caption)
                        Text("Director: ${movie.actors}", style = MaterialTheme.typography.caption)
                        Text("Director: ${movie.director}", style = MaterialTheme.typography.caption)
                    }
                }

                Icon(imageVector = if(!expanded.value) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp,
                    contentDescription = "Down Arrow",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expanded.value = !expanded.value
                        },
                )
            }
        }

    }
}