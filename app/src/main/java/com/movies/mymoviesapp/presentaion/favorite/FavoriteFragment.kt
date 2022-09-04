package com.movies.mymoviesapp.presentaion.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.movies.mymoviesapp.databinding.FragmentFavoriteBinding
import com.movies.mymoviesapp.presentaion.main.MainFragmentAdapter

class FavoriteFragment : Fragment() {

    private var _mFavoriteBinding: FragmentFavoriteBinding? = null
    private val mBinding get() = _mFavoriteBinding!!

    private lateinit var recyclerView: RecyclerView
    private val mAdapter by lazy { MainFragmentAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mFavoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[FavoriteFragmentViewModel::class.java]
        recyclerView = mBinding.rvFavorite
        recyclerView.adapter = mAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _mFavoriteBinding = null
    }

}