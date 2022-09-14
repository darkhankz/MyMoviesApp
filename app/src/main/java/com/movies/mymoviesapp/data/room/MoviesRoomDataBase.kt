package com.movies.mymoviesapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.movies.mymoviesapp.data.room.dao.MoviesDao
import com.movies.mymoviesapp.domain.models.Movie

@Database(entities = [Movie::class], version = 1 )
abstract class MoviesRoomDataBase: RoomDatabase() {
    abstract fun getMovieDao(): MoviesDao

    companion object{
        private var database: MoviesRoomDataBase? = null

        fun getInstance(context: Context): MoviesRoomDataBase{
            return if (database == null) {
                database = Room
                    .databaseBuilder(context, MoviesRoomDataBase::class.java, "db")
                    .build()
                database as MoviesRoomDataBase
            } else{
                database as MoviesRoomDataBase
            }
        }
    }
}