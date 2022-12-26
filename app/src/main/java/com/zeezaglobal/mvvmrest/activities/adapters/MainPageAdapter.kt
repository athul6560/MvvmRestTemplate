package com.zeezaglobal.mvvmrest.activities.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zeezaglobal.mvvmrest.data.enitities.MainContent
import com.zeezaglobal.mvvmrest.databinding.MainRecyclerviewElementBinding

class MainPageAdapter : RecyclerView.Adapter<MainPageAdapter.ViewHolder>() {
    private var mainList = ArrayList<MainContent>()
    fun setMovieList(movieList : List<MainContent>){
        this.mainList = movieList as ArrayList<MainContent>
        notifyDataSetChanged()
    }
    class ViewHolder(val binding : MainRecyclerviewElementBinding) : RecyclerView.ViewHolder(binding.root)  {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MainRecyclerviewElementBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      /*  Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500"+movieList[position].poster_path)
            .into(holder.binding.movieImage)*/
        holder.binding.movieName.text = mainList[position].title
    }
    override fun getItemCount(): Int {
        return mainList.size
    }}