package com.zeezaglobal.mvvmrest.localdb.dao

import androidx.room.Dao

import androidx.room.Insert

import com.zeezaglobal.mvvmrest.dto.MainContentDataObject


@Dao
interface NewsDao {


    @Insert
    fun insertAll(news: MainContentDataObject)


}