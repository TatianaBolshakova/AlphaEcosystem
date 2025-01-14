package com.example.alphaecosystem.data.network

import com.example.alphaecosystem.data.models.InfoByBinCard
import retrofit2.http.GET
import retrofit2.http.Path



interface Api{
    @GET("/{id}")
    suspend fun getInfoByBin(
        @Path("id") bin: Int
        ): InfoByBinCard
}
