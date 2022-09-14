package com.movies.mymoviesapp.data.retrofit.api

import com.movies.mymoviesapp.domain.models.MoviesPopularModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("3/movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String = "6e76ecffda0a59dc4f19a343c6e7648a",
        @Query("page") page: Int): Response<MoviesPopularModel>
}