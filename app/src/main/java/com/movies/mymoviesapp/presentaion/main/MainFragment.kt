package com.movies.mymoviesapp.presentaion.main

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.movies.mymoviesapp.R
import com.movies.mymoviesapp.common.MAIN
import com.movies.mymoviesapp.databinding.FragmentMainBinding
import com.movies.mymoviesapp.domain.models.Result


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
        setHasOptionsMenu(true)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
        viewModel.initDataBase()
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


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_favorite -> {
                MAIN.navController.navigate(R.id.action_mainFragment_to_favoriteFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
    companion object{
        fun clickMovie(model: Result){
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAIN.navController.navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }
    }
}