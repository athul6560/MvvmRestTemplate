package com.zeezaglobal.mvvmrest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Database
import androidx.room.Room
import com.zeezaglobal.mvvmrest.R
import com.zeezaglobal.mvvmrest.activities.adapters.MainPageAdapter
import com.zeezaglobal.mvvmrest.apis.RetrofitHelper
import com.zeezaglobal.mvvmrest.apis.RetrofitInterface
import com.zeezaglobal.mvvmrest.databinding.ActivityMainBinding
import com.zeezaglobal.mvvmrest.dto.MainContentDataObject

import com.zeezaglobal.mvvmrest.viewmodel.MainContentViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainContentViewModel
    private lateinit var movieAdapter : MainPageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MainContentViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
            movieAdapter.setMovieList(movieList)
        })

    }
    private fun prepareRecyclerView() {
        movieAdapter = MainPageAdapter()
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext,2)
            adapter = movieAdapter
        }
    }
}
