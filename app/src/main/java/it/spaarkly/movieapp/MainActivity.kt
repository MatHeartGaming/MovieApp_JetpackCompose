package it.spaarkly.movieapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.spaarkly.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable ()-> Unit) {
    MovieAppTheme {
        Scaffold(topBar = {
            TopAppBar(backgroundColor = Color.Magenta,
            elevation = 5.dp,) {
                Text("Movies")
            }
        }) {it
            content()
        }
    }
}

@Composable
fun MainContent(movieList : List<String> = listOf(
    "Avatar", "All quiet on the Western Front", "Harry Potter",
    "Nightmare before Christmas", "Mulan", "Pulp Fiction",
    "Wednesday", "1917", "Oppenheimer")
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background,
    ) {
        Column(modifier = Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp)) {
            LazyColumn{
                items(movieList){
                    MovieRow(movie = it) {
                        Log.d("Tap", "MainContent: $it")
                    }
                }
            }
        }
    }

}

@Composable
fun MovieRow(movie : String, onItemClick : (String)-> Unit = {}) {
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp)
        .clickable {
            onItemClick(movie)
        },
        shape = RoundedCornerShape(16.dp),
    elevation = 6.dp) {
        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
            shape = RectangleShape,
            elevation = 5.dp) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Icon Movie")
            }
            Text(text = movie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}