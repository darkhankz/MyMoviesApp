package com.movies.mymoviesapp.presentaion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.movies.mymoviesapp.R
import com.movies.mymoviesapp.common.MAIN

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MAIN = this
    }
}