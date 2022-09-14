package com.movies.mymoviesapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.movies.mymoviesapp.domain.models.Movie

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(result: Movie)

    @Delete
    suspend fun delete(result: Movie)

    @Query("SELECT * from movie_table")
    fun getAllMovies(): LiveData<List<Movie>>

}