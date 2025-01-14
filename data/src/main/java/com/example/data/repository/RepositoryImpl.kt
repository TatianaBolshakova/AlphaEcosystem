package com.example.data.repository

import com.example.data.network.retrofit
import com.example.domain.models.InfoByBinCard
import com.example.domain.repository.Repository

class RepositoryImpl: Repository {
    override suspend fun getInfoByBin(bin: Int): InfoByBinCard {
        return  retrofit.getInfoByBin(bin = bin)
    }
}