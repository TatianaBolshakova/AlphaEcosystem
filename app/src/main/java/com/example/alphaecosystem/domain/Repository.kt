package com.example.alphaecosystem.domain

import com.example.alphaecosystem.data.models.InfoByBinCard

interface Repository {
    suspend fun getInfoByBin(bin: Int): InfoByBinCard
}