package com.sabekur2017.digitalwallet.presentation.home

import com.sabekur2017.digitalwallet.domain.models.*

data class HomeUiState(
    val isLoading: Boolean = false,
    val walletInfo: UserWalletInfo? = null,
    val services: List<ServiceItem> = emptyList(),
    val promotions: List<Promotion> = emptyList(),
    val merchants: List<Merchant> = emptyList(),
    val error: String? = null
)
