package com.movies.mymoviesapp.domain.repository

import androidx.lifecycle.LiveData
import com.movies.mymoviesapp.domain.models.MoviesPopularModel

interface MoviesRepository {
    fun getMoviesPopular() : LiveData<List<MoviesPopularModel>>

}