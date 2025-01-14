package com.example.alphaecosystem.presentation.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.db.Card
import com.example.data.db.CardDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class HistoryViewModel @Inject constructor (
     private val cardDao: CardDao
): ViewModel(){

    var allCard: StateFlow<List<Card>> = this.cardDao.getAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    fun addCard(newCard: Card) {
        viewModelScope.launch(Dispatchers.IO) {
            cardDao.insert(newCard)
        }
    }
}