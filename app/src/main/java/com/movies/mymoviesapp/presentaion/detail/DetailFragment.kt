package com.movies.mymoviesapp.presentaion.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.movies.mymoviesapp.R
import com.movies.mymoviesapp.SaveShared
import com.movies.mymoviesapp.common.MAIN
import com.movies.mymoviesapp.common.MOVIE_URL
import com.movies.mymoviesapp.databinding.FragmentDetailBinding
import com.movies.mymoviesapp.domain.models.Result

class DetailFragment : Fragment() {

    private var _mDetailBinding: FragmentDetailBinding? = null
    private val mBinding get() = _mDetailBinding!!
    private lateinit var currentMovie: Result
    private var isFavorite = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mDetailBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentMovie = arguments?.getSerializable("movie") as Result
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val valueBoolean = SaveShared.getFavorit(MAIN, currentMovie.id.toString())
        val viewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        if (isFavorite != valueBoolean){
            mBinding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        }else{
            mBinding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)

        }

        Glide
            .with(MAIN)
            .load(MOVIE_URL + currentMovie.backdrop_path)
            .centerCrop()
            .into(mBinding.imgDetail)
        mBinding.tvTitleDetails.text = currentMovie.title
        mBinding.tvDateDetails.text = currentMovie.release_date
        mBinding.tvOverviewDetails.text = currentMovie.overview
        mBinding.tvRatingDetails.text = currentMovie.vote_average.toString()

        mBinding.imgDetailFavorite.setOnClickListener {
            isFavorite = if (isFavorite == valueBoolean) {
                mBinding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                SaveShared.setFavorit(MAIN, currentMovie.id.toString(), true)
                viewModel.insert(currentMovie){}
                true
            } else{
                mBinding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                viewModel.delete(currentMovie){}
                SaveShared.setFavorit(MAIN, currentMovie.id.toString(), false)
                false
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _mDetailBinding = null
    }

}