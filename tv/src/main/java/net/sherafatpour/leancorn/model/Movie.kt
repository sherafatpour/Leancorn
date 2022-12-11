package net.sherafatpour.leancorn.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("actors")
    val actors: List<String>,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("directors")
    val directors: List<String>,
    @SerializedName("genre")
    val genre: List<String>,
    @SerializedName("image_url")
    val image_url: String,
    @SerializedName("imdb_url")
    val imdb_url: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("thumb_url")
    val thumb_url: String,
    @SerializedName("year")
    val year: Int?


)