package com.example.data.network

import com.example.domain.models.InfoByBinCard
import retrofit2.http.GET
import retrofit2.http.Path



interface Api{
    @GET("/{id}")
    suspend fun getInfoByBin(
        @Path("id") bin: Int
        ): InfoByBinCard
}
