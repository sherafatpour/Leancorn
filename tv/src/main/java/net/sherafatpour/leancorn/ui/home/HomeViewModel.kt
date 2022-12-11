package net.sherafatpour.leancorn.ui.home

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import net.sherafatpour.leancorn.data.repo.MovieRepository
import net.sherafatpour.leancorn.model.Category
import net.sherafatpour.leancorn.model.Movie
import net.sherafatpour.leancorn.util.Resource
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private val _moviesResponse = MutableStateFlow<Resource<List<Category>>>(Resource.Idle())
    val moviesResponse = _moviesResponse.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch{
            with(_moviesResponse) {
                tryEmit(Resource.Loading())
                tryEmit(Resource.Success(repository.getMovies().categorize()))
                //TODO : Handle network error


            }
        }
    }

      private fun List<Movie>.categorize(): List<Category> {
        val genreSet = mutableSetOf<String>()
        for (movie in this) {
            for (genre in movie.genre) {
                genreSet.add(genre)
            }
        }
        val feedItems = mutableListOf<Category>()
        for ((index, genre) in genreSet.withIndex()) {
            val genreMovies = this.filter { it.genre.contains(genre) }
            feedItems.add(
                Category(
                    index.toLong(), genre, genreMovies
                )
            )
        }
        return feedItems
    }


}