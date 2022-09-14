package com.movies.mymoviesapp.presentaion.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.movies.mymoviesapp.common.MOVIE_REPOSItORY_IMPL
import com.movies.mymoviesapp.domain.models.Movie

class FavoriteFragmentViewModel: ViewModel() {

    fun getAllMovies(): LiveData<List<Movie>>{
        return MOVIE_REPOSItORY_IMPL.allMovies
    }
}