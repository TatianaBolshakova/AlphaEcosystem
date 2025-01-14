package com.example.alphaecosystem.data.repository

import com.example.alphaecosystem.data.network.retrofit
import com.example.alphaecosystem.data.models.InfoByBinCard
import com.example.alphaecosystem.domain.Repository

class RepositoryImpl:Repository {
    override suspend fun getInfoByBin(bin: Int): InfoByBinCard {
        return  retrofit.getInfoByBin(bin = bin)
    }
}