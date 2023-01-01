package com.zeezaglobal.mvvmrest.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Database
import com.huawei.todolist.utils.subscribeOnBackground
import com.zeezaglobal.mvvmrest.apis.RetrofitHelper
import com.zeezaglobal.mvvmrest.apis.RetrofitInterface
import com.zeezaglobal.mvvmrest.data.enitities.MainContent
import com.zeezaglobal.mvvmrest.dto.MainContentDataObject
import com.zeezaglobal.mvvmrest.localdb.NewsDatabase
import com.zeezaglobal.mvvmrest.localdb.dao.NewsDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.security.auth.callback.Callback

class MainContentViewModel(app: Application) : AndroidViewModel(app) {
    private var noteDao: NewsDao


    private val database = NewsDatabase.getInstance(app)

    init {
        noteDao = database.newsDao()
        insert(
            MainContentDataObject(
                45, "fdgd",
                "fdgd",
                "fdgd",
                "fdgd",
                "fdgd",
                456,
                "fdgd",
                4353,
                "fdgd",
                "fdgd", true,
                true,
                "fdgd",
                "fdgd",
                "fdgd"
            )
        )
    }

    private var movieLiveData = MutableLiveData<List<MainContent>>()
    fun getPopularMovies() {

        val quotesApi = RetrofitHelper.getInstance().create(RetrofitInterface::class.java)

        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            movieLiveData.postValue(result.body())
        }
    }

    fun observeMovieLiveData(): LiveData<List<MainContent>> {
        return movieLiveData
    }

    fun insert(note: MainContentDataObject) {

        subscribeOnBackground {
            noteDao.insertAll(note)
        }
    }
}