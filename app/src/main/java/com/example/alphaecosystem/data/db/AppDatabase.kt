package com.example.alphaecosystem.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Card::class], version = 1
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun cardDao(): CardDao
}