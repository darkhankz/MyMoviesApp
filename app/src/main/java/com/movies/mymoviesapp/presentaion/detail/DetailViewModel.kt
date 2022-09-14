package com.movies.mymoviesapp.presentaion.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.mymoviesapp.common.MOVIE_REPOSItORY_IMPL
import com.movies.mymoviesapp.domain.models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {
    fun delete(result: Movie, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            MOVIE_REPOSItORY_IMPL.deleteMovie(result){
                onSuccess()
            }
        }
    fun insert(result: Movie, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            MOVIE_REPOSItORY_IMPL.insertMovie(result){
                onSuccess()
            }

        }
}