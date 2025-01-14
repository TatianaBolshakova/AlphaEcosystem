package com.example.alphaecosystem.app

import android.app.Application
import androidx.room.Room
import com.example.data.db.AppDataBase
import javax.inject.Inject

class App @Inject constructor() : Application() {
    lateinit var db: AppDataBase

    override fun onCreate() {
        super.onCreate()

        db = Room
            .databaseBuilder(
                applicationContext,
                AppDataBase::class.java,
                "db"
            )
            .build()
    }
}