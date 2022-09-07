package com.movies.mymoviesapp.common

import com.movies.mymoviesapp.data.room.repository.MoviesRepositoryImpl
import com.movies.mymoviesapp.presentaion.MainActivity

lateinit var MAIN: MainActivity
const val BASE_URL = "https://api.themoviedb.org/"
const val MOVIE_URL = "https://image.tmdb.org/t/p/w500/"
lateinit var MOVIE_REPOSItORY_IMPL: MoviesRepositoryImpl
