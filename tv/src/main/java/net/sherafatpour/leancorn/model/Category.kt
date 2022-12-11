package net.sherafatpour.leancorn.model

data class Category(
    val id: Long,
    val genre: String,
    val movies: List<Movie>
)
