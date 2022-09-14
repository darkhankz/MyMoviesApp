package com.movies.mymoviesapp.domain.models

data class MoviesPopularModel(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)