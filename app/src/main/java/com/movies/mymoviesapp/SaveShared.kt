package com.movies.mymoviesapp

import android.content.Context
import android.preference.PreferenceManager

@Suppress("DEPRECATION")
class SaveShared {
    companion object{
        fun setFavorit(context: Context?, key: String, value: Boolean){
            val setFavoriteShared = PreferenceManager.getDefaultSharedPreferences(context)
            setFavoriteShared.edit().putBoolean(key, value).apply()
        }
        fun getFavorit(context: Context?, key: String): Boolean{
            val getFavoriteShared = PreferenceManager.getDefaultSharedPreferences(context)
            return getFavoriteShared.getBoolean(key, false)
        }
    }
}