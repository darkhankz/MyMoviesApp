package com.movies.mymoviesapp.presentaion.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.movies.mymoviesapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _mMainBinding: FragmentMainBinding ? = null
    private val mBinding get() = _mMainBinding!!

    private lateinit var recyclerView: RecyclerView
    private val mAdapter by lazy { MainFragmentAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _mMainBinding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
        viewModel.getMovies()
        recyclerView = mBinding.rvMain
        recyclerView.adapter = mAdapter
        viewModel.myMovie.observe(viewLifecycleOwner) { list ->
            mAdapter.setList(list.body()!!.results)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _mMainBinding = null
    }


}