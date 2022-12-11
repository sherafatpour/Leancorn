package net.sherafatpour.leancorn.data.remote


import net.sherafatpour.leancorn.model.Movie
import retrofit2.http.GET

interface MoviesApi {

    @GET("top250_min.json")
    suspend fun getMovies(): List<Movie>


}