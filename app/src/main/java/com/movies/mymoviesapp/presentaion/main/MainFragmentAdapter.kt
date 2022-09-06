package com.movies.mymoviesapp.presentaion.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.movies.mymoviesapp.R
import com.movies.mymoviesapp.common.MAIN
import com.movies.mymoviesapp.common.MOVIE_URL
import com.movies.mymoviesapp.domain.models.Result
import kotlinx.android.synthetic.main.item_card.view.*

class MainFragmentAdapter: RecyclerView.Adapter<MainFragmentAdapter.ViewHolder>() {
    private var listMovies = emptyList<Result>()
    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.item_title_card.text = listMovies[position].title
        holder.itemView.item_date_card.text = listMovies[position].release_date
        Glide
            .with(MAIN)
            .load(MOVIE_URL + listMovies[position].poster_path)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.item_image_card)

    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Result>){
        listMovies = list
        notifyDataSetChanged()


    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            MainFragment.clickMovie(listMovies[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

}