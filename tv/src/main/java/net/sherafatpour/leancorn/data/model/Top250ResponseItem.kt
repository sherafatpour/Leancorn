package net.sherafatpour.leancorn.data.model

data class Top250ResponseItem(
    val actors: List<String>,
    val desc: String,
    val directors: List<String>,
    val genre: List<String>,
    val image_url: String,
    val imdb_url: String,
    val name: String,
    val rating: Double,
    val thumb_url: String,
    val year: Int
)