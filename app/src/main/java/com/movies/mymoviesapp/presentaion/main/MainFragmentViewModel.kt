package com.movies.mymoviesapp.presentaion.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.mymoviesapp.data.retrofit.RetrofitRepository
import com.movies.mymoviesapp.domain.models.MoviesPopularModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel: ViewModel() {
    private val repository = RetrofitRepository()
    val myMovie: MutableLiveData<Response<MoviesPopularModel>> = MutableLiveData()

    fun getMovies(){
        viewModelScope.launch {
            myMovie.value = repository.getMovies()
        }
    }
}
