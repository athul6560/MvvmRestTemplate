package com.zeezaglobal.mvvmrest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zeezaglobal.mvvmrest.R
import com.zeezaglobal.mvvmrest.apis.retrofitHelper
import com.zeezaglobal.mvvmrest.apis.retrofitInterface
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesApi = retrofitHelper.getInstance().create(retrofitInterface::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            if (result != null)
            // Checking the results
                Log.d("ayush: ", result.body().toString())
        }

    }
}