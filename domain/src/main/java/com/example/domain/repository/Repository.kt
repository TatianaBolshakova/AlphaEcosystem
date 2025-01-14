package com.example.domain.repository

import com.example.domain.models.InfoByBinCard


interface Repository {
    suspend fun getInfoByBin(bin: Int): InfoByBinCard
}