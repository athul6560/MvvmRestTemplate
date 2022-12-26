package com.zeezaglobal.mvvmrest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zeezaglobal.mvvmrest.apis.RetrofitHelper
import com.zeezaglobal.mvvmrest.apis.RetrofitInterface
import com.zeezaglobal.mvvmrest.data.enitities.MainContent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.security.auth.callback.Callback

class MainContentViewModel : ViewModel() {
    private var movieLiveData = MutableLiveData<List<MainContent>>()
    fun getPopularMovies() {

        val quotesApi = RetrofitHelper.getInstance().create(RetrofitInterface::class.java)

        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            movieLiveData.postValue(result.body())
        }
    }
    fun observeMovieLiveData() : LiveData<List<MainContent>> {
        return movieLiveData
    }
}