package com.example.domain.usecase


import com.example.domain.models.InfoByBinCard
import com.example.domain.repository.Repository

import javax.inject.Inject

class GetInfoCardUseCase @Inject constructor (private val repository: Repository) {
     suspend fun getInfoCard(bin: Int): InfoByBinCard {
        return repository.getInfoByBin(bin = bin)}

}