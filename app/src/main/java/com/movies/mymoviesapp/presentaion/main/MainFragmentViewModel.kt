package com.movies.mymoviesapp.presentaion.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.movies.mymoviesapp.common.MOVIE_REPOSItORY_IMPL
import com.movies.mymoviesapp.data.retrofit.RetrofitRepository
import com.movies.mymoviesapp.data.room.MoviesRoomDataBase
import com.movies.mymoviesapp.data.room.repository.MoviesRepositoryImpl
import com.movies.mymoviesapp.domain.models.MoviesPopularModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    private val repository = RetrofitRepository()
    private lateinit var moviesRepositoryImpl: MoviesRepositoryImpl
    val myMovie: MutableLiveData<Response<MoviesPopularModel>> = MutableLiveData()
    private val context = application

    fun getMovies(){
        viewModelScope.launch {
            myMovie.value = repository.getMovies()
        }
    }

    fun initDataBase() {
        val daoMovie = MoviesRoomDataBase.getInstance(context).getMovieDao()
        MOVIE_REPOSItORY_IMPL = MoviesRepositoryImpl(daoMovie)

    }
}
