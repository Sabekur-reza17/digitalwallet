package com.sabekur2017.digitalwallet.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sabekur2017.digitalwallet.domain.usecases.GetHomeDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeDataUseCase: GetHomeDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadHomeData()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.Refresh -> {
                loadHomeData()
            }
        }
    }

    private fun loadHomeData() {
        viewModelScope.launch {
            getHomeDataUseCase()
                .onStart {
                    _uiState.update { it.copy(isLoading = true, error = null) }
                }
                .catch { e ->
                    _uiState.update { it.copy(isLoading = false, error = e.message ?: "An unknown error occurred") }
                }
                .collect { homeData ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            walletInfo = homeData.walletInfo,
                            services = homeData.services,
                            promotions = homeData.promotions,
                            merchants = homeData.merchants
                        )
                    }
                }
        }
    }
}
