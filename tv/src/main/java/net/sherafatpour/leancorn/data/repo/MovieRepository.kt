package net.sherafatpour.leancorn.data.repo

import net.sherafatpour.leancorn.data.remote.MoviesApi
import javax.inject.Inject

class MovieRepository @Inject constructor(private val moviesApi: MoviesApi): MoviesApi by moviesApi