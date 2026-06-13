package com.sabekur2017.digitalwallet.data.sources

import com.sabekur2017.digitalwallet.data.models.*

interface WalletDatasource {
    suspend fun getWalletInfo(): UserWalletInfoDto
    suspend fun getServices(): List<ServiceItemDto>
    suspend fun getPromotions(): List<PromotionDto>
    suspend fun getNearbyMerchants(): List<MerchantDto>
    suspend fun getTransactions(): List<TransactionDto>
    suspend fun getUserProfile(): UserProfileDto
    suspend fun getSettingsCategories(): List<SettingsCategoryDto>
}
