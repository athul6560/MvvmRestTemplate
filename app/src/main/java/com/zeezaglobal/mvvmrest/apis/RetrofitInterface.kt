package com.zeezaglobal.mvvmrest.apis

import com.zeezaglobal.mvvmrest.data.enitities.MainContent
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("items?lineupSlug=news")
    suspend fun getQuotes() : Response<List<MainContent>>
}