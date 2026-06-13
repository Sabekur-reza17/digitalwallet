package com.sabekur2017.digitalwallet.domain.repositories

import com.sabekur2017.digitalwallet.domain.models.*
import kotlinx.coroutines.flow.Flow

interface WalletRepositories {
    fun getWalletInfo(): Flow<UserWalletInfo>
    fun getServices(): Flow<List<ServiceItem>>
    fun getPromotions(): Flow<List<Promotion>>
    fun getNearbyMerchants(): Flow<List<Merchant>>
    fun getTransactions(): Flow<List<Transaction>>
    fun getUserProfile(): Flow<UserProfile>
    fun getSettingsCategories(): Flow<List<SettingsCategory>>
}
