package com.movies.mymoviesapp.data.room.repository

import androidx.lifecycle.LiveData
import com.movies.mymoviesapp.data.room.dao.MoviesDao
import com.movies.mymoviesapp.domain.models.Movie

class MoviesRepositoryImpl(private val moviesDao: MoviesDao): MoviesRepository {
    override val allMovies: LiveData<List<Movie>>
        get() = moviesDao.getAllMovies()

    override suspend fun insertMovie(result: Movie, onSuccess: () -> Unit) {
        moviesDao.insert(result)
        onSuccess
    }

    override suspend fun deleteMovie(result: Movie, onSuccess: () -> Unit) {
        moviesDao.delete(result)
        onSuccess
    }
}