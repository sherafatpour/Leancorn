package net.sherafatpour.leancorn.data.remote

import net.sherafatpour.leancorn.data.model.Top250Response
import retrofit2.http.GET

interface MoviesApi {

    @GET("https://raw.githubusercontent.com/theapache64/top250/master/top250_min.json")
    suspend fun getTop250():Top250Response

}