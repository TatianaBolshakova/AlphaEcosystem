package com.example.alphaecosystem.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.InfoByBinCard

import com.example.domain.usecase.GetInfoCardUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchByBinViewModel  @Inject constructor(
    private val getInfoCardUseCase: GetInfoCardUseCase
): ViewModel(){

    private val _info = MutableStateFlow <InfoByBinCard?>(value = null)
    val info = _info.asStateFlow()

    fun loadInfo(bin: Int) {
        viewModelScope.launch(Dispatchers.IO){
            kotlin.runCatching {
                getInfoCardUseCase.getInfoCard(bin = bin)
            }.fold(
                onSuccess = {_info.value = it},
                onFailure = { Log.d("SearchByBinViewModel", it.message ?: "")}
            )
        }
    }
}