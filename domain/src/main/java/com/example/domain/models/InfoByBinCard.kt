package com.example.domain.models

data class InfoByBinCard(
    val scheme: String,
    val type: String,
    val country: Country,
    val bank: Bank
)
data class Country(
    val name: String,
    val emoji: String,
    val latitude: Int,
    val longitude: Int
)
data class Bank(
    val name : String,
    val url : String,
    val phone : String,
    val city : String,

)