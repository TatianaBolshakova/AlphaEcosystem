package com.example.alphaecosystem.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alphaecosystem.data.models.InfoByBinCard
import com.example.alphaecosystem.data.repository.RepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchByBinViewModel private constructor(
    private val repository: RepositoryImpl
): ViewModel(){
    constructor():this(RepositoryImpl())
    private val _info = MutableStateFlow <InfoByBinCard?>(value = null)
    val info = _info.asStateFlow()

    fun loadInfo(bin: Int) {
        viewModelScope.launch(Dispatchers.IO){
            kotlin.runCatching {
                repository.getInfoByBin(bin = bin)
            }.fold(
                onSuccess = {_info.value = it},
                onFailure = { Log.d("SearchByBinViewModel", it.message ?: "")}
            )
        }
    }
}