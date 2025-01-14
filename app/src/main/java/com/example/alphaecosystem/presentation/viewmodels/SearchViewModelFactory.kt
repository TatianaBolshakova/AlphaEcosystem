package com.example.alphaecosystem.presentation.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject


class SearchViewModelFactory @Inject constructor(
    private val searchViewModel: SearchByBinViewModel
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchByBinViewModel::class.java)){

           return searchViewModel as T
        }
        throw IllegalArgumentException(" ")
    }
}


