package com.movies.mymoviesapp.data.retrofit

import com.movies.mymoviesapp.data.retrofit.api.RetrofitInstance
import com.movies.mymoviesapp.domain.models.MoviesPopularModel
import retrofit2.Response

class RetrofitRepository  {
    suspend fun getMovies(): Response<MoviesPopularModel> {
        return RetrofitInstance.api.getPopularMovie()
    }
}