package com.movies.mymoviesapp.data.room.repository

import androidx.lifecycle.LiveData
import com.movies.mymoviesapp.domain.models.Movie

interface MoviesRepository {
    val allMovies: LiveData<List<Movie>>
    suspend fun insertMovie(result: Movie, onSuccess:() -> Unit)
    suspend fun deleteMovie(result: Movie, onSuccess:() -> Unit)


}