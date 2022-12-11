package net.sherafatpour.leancorn.util

sealed class Resource<T> {
    class Idle<T> : Resource<T>()
    class Loading<T> : Resource<T>()
    data class Success<T>(val data: T, val message: String? = null) : Resource<T>()
    data class Error<T>( val message: String) : Resource<T>()
}