package com.movies.mymoviesapp.data.room.repository

import androidx.lifecycle.LiveData
import com.movies.mymoviesapp.domain.models.Result

interface MoviesRepository {
    val allMovies: LiveData<List<Result>>
    suspend fun insertMovie(result: Result, onSuccess:() -> Unit)
    suspend fun deleteMovie(result: Result, onSuccess:() -> Unit)


}