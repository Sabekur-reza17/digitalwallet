package com.sabekur2017.digitalwallet.presentation.history

sealed class HistoryEvent {
    object LoadTransactions : HistoryEvent()
    data class SearchTransactions(val query: String) : HistoryEvent()
}
