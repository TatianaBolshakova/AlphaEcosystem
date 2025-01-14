package com.example.alphaecosystem.presentation.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject


class HistoryViewModelFactory @Inject constructor(
    private val historyViewModel: HistoryViewModel
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoryViewModel::class.java)){

           return historyViewModel as T
        }
        throw IllegalArgumentException(" ")
    }
}


