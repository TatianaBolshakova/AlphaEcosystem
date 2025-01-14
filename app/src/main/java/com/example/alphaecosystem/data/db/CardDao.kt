package com.example.alphaecosystem.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface CardDao {

    @Query("SELECT * FROM card")
    fun getAll(): Flow<List<Card>>

    @Insert(entity = Card::class, onConflict = OnConflictStrategy.REPLACE)
    fun insert(card: Card)

    @Delete
    fun delete(card: Card)

    @Update
    fun update(card: Card)
}