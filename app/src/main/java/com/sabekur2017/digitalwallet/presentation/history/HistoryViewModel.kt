package com.sabekur2017.digitalwallet.presentation.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sabekur2017.digitalwallet.domain.usecases.GetTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getTransactionsUseCase: GetTransactionsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HistoryUiState())
    val uiState: StateFlow<HistoryUiState> = _uiState.asStateFlow()

    init {
        onEvent(HistoryEvent.LoadTransactions)
    }

    fun onEvent(event: HistoryEvent) {
        when (event) {
            is HistoryEvent.LoadTransactions -> loadTransactions()
            is HistoryEvent.SearchTransactions -> {
                _uiState.update { it.copy(searchQuery = event.query) }
            }
        }
    }

    private fun loadTransactions() {
        viewModelScope.launch {
            getTransactionsUseCase()
                .onStart { _uiState.update { it.copy(isLoading = true) } }
                .catch { e -> _uiState.update { it.copy(isLoading = false, error = e.message) } }
                .collect { transactions ->
                    _uiState.update { it.copy(isLoading = false, transactions = transactions) }
                }
        }
    }
}
