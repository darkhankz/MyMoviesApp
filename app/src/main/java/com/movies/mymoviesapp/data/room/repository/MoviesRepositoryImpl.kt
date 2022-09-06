package com.movies.mymoviesapp.data.room.repository

import androidx.lifecycle.LiveData
import com.movies.mymoviesapp.data.room.dao.MoviesDao
import com.movies.mymoviesapp.domain.models.Result

class MoviesRepositoryImpl(private val moviesDao: MoviesDao): MoviesRepository {
    override val allMovies: LiveData<List<Result>>
        get() = moviesDao.getAllMovies()

    override suspend fun insertMovie(result: Result, onSuccess: () -> Unit) {
        moviesDao.insert(result)
        onSuccess
    }

    override suspend fun deleteMovie(result: Result, onSuccess: () -> Unit) {
        moviesDao.delete(result)
        onSuccess
    }
}