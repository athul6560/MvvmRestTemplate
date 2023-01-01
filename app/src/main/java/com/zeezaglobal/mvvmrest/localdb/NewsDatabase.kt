package com.zeezaglobal.mvvmrest.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.huawei.todolist.utils.subscribeOnBackground
import com.zeezaglobal.mvvmrest.dto.MainContentDataObject
import com.zeezaglobal.mvvmrest.localdb.dao.NewsDao

@Database(entities = [MainContentDataObject::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
    companion object {
        private var instance: NewsDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): NewsDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, NewsDatabase::class.java,
                    "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()

            return instance!!

        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

            }
        }


    }

}