package com.movies.mymoviesapp.presentaion.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.movies.mymoviesapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _mDetailBinding: FragmentDetailBinding? = null
    private val mBinding get() = _mDetailBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mDetailBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[DetailViewModel::class.java]

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _mDetailBinding = null
    }

}