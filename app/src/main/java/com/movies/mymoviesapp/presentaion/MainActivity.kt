package com.movies.mymoviesapp.presentaion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.movies.mymoviesapp.R
import com.movies.mymoviesapp.common.MAIN
import com.movies.mymoviesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment


    private var _mMainBinding: ActivityMainBinding? = null
    private val mBinding get() = _mMainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        MAIN = this
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onDestroy() {
        super.onDestroy()
        _mMainBinding = null
    }
}