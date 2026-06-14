package com.sabekur2017.digitalwallet.presentation.history

import com.sabekur2017.digitalwallet.domain.models.Transaction

data class HistoryUiState(
    val isLoading: Boolean = false,
    val transactions: List<Transaction> = emptyList(),
    val error: String? = null,
    val searchQuery: String = ""
)
