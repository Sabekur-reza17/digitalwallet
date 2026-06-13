package com.sabekur2017.digitalwallet.domain.models

data class HomeData(
    val walletInfo: UserWalletInfo,
    val services: List<ServiceItem>,
    val promotions: List<Promotion>,
    val merchants: List<Merchant>
)
