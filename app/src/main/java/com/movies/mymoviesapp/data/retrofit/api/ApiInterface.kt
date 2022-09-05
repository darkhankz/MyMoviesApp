package com.movies.mymoviesapp.data.retrofit.api

import com.movies.mymoviesapp.domain.models.MoviesPopularModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("3/movie/popular?api_key=6e76ecffda0a59dc4f19a343c6e7648a")
    suspend fun getPopularMovie(): Response<MoviesPopularModel>

}