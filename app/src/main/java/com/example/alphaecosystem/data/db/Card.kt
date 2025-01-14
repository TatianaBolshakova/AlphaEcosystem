package com.example.alphaecosystem.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card")
data class Card(

    @PrimaryKey
    @ColumnInfo(name = "bin")
    val bin: Int,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "emoji")
    val emoji: String,
    @ColumnInfo(name = "latitude")
    val latitude: String,
    @ColumnInfo(name = "longitude")
    val longitude: String,
    @ColumnInfo(name = "name_bank")
    val nameBank: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "city")
    val city: String,
)
