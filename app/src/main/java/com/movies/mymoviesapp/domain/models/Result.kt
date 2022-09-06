package com.movies.mymoviesapp.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie_table")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val overview: String,

    val backdrop_path: String,

    val poster_path: String,

    val release_date: String,

    val title: String,

    val vote_average: Double,
) : Serializable