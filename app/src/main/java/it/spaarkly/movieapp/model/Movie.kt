package it.spaarkly.movieapp.model

data class Movie(
    val id: String,
    val title: String,
    val year: String,
    val genre: String,
    val director: String,
    val actors: String,
    val plot: String,
    val poster: String,
    val images: List<String>,
    val rating: String
)

fun getMovies(): List<Movie> {
    val movie1 = Movie(
        id = "1",
        title = "Movie 1",
        year = "2020",
        genre = "Action",
        director = "Mamt",
        actors = "Sort",
        plot = "Good plot",
        poster = "sdsds",
        images = listOf("", "", "", ""),
        rating = "4/5"
    )
    val movie2 = Movie(
        id = "2",
        title = "Movie 2",
        year = "2020",
        genre = "Action",
        director = "Mamt",
        actors = "Sort",
        plot = "Good plot",
        poster = "sdsds",
        images = listOf("", "", "", ""),
        rating = "4/5"
    )
    val movie3 = Movie(
        id = "3",
        title = "Movie 3",
        year = "2020",
        genre = "Action",
        director = "Mamt",
        actors = "Sort",
        plot = "Good plot",
        poster = "sdsds",
        images = listOf("", "", "", ""),
        rating = "4/5"
    )
    val movie4 = Movie(
        id = "4",
        title = "Movie 4",
        year = "2020",
        genre = "Action",
        director = "Mamt",
        actors = "Sort",
        plot = "Good plot",
        poster = "sdsds",
        images = listOf("", "", "", ""),
        rating = "4/5"
    )
    val movie5 = Movie(
        id = "5",
        title = "Movie 5",
        year = "2020",
        genre = "Action",
        director = "Mamt",
        actors = "Sort",
        plot = "Good plot",
        poster = "sdsds",
        images = listOf("", "", "", ""),
        rating = "4/5"
    )
    val movie6 = Movie(
        id = "6",
        title = "Movie 6",
        year = "2020",
        genre = "Action",
        director = "Mamt",
        actors = "Sort",
        plot = "Good plot",
        poster = "sdsds",
        images = listOf("", "", "", ""),
        rating = "4/5"
    )
    val movie7 = Movie(
        id = "7",
        title = "Movie 7",
        year = "2020",
        genre = "Action",
        director = "Mamt",
        actors = "Sort",
        plot = "Good plot",
        poster = "sdsds",
        images = listOf("", "", "", ""),
        rating = "4/5"
    )
    val movie8 = Movie(
        id = "8",
        title = "Movie 8",
        year = "2020",
        genre = "Action",
        director = "Mamt",
        actors = "Sort",
        plot = "Good plot",
        poster = "sdsds",
        images = listOf("", "", "", ""),
        rating = "4/5"
    )
    val movie9 = Movie(
        id = "9",
        title = "Movie 9",
        year = "2020",
        genre = "Action",
        director = "Mamt",
        actors = "Sort",
        plot = "Good plot",
        poster = "sdsds",
        images = listOf("", "", "", ""),
        rating = "4/5"
    )
    val movie10 = Movie(
        id = "10",
        title = "Movie 10",
        year = "2020",
        genre = "Action",
        director = "Mamt",
        actors = "Sort",
        plot = "Good plot",
        poster = "sdsds",
        images = listOf("", "", "", ""),
        rating = "4/5"
    )
    val movie11 = Movie(
        id = "11",
        title = "Movie 11",
        year = "2020",
        genre = "Action",
        director = "Mamt",
        actors = "Sort",
        plot = "Good plot",
        poster = "sdsds",
        images = listOf("", "", "", ""),
        rating = "4/5"
    )
    return listOf(
        movie1,
        movie2,
        movie3,
        movie4,
        movie5,
        movie6,
        movie7,
        movie8,
        movie9,
        movie10,
        movie11,
    )
}