package com.movies.mymoviesapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.movies.mymoviesapp.domain.models.Result

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(result: Result)

    @Delete
    suspend fun delete(result: Result)

    @Query("SELECT * from")
    fun getAllMovies(): LiveData<List<Result>>

}