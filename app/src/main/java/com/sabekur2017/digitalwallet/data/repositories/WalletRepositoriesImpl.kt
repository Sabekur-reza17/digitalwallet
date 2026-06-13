package com.sabekur2017.digitalwallet.data.repositories

import com.sabekur2017.digitalwallet.data.mapper.*
import com.sabekur2017.digitalwallet.data.sources.WalletDatasource
import com.sabekur2017.digitalwallet.domain.models.*
import com.sabekur2017.digitalwallet.domain.repositories.WalletRepositories
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WalletRepositoriesImpl @Inject constructor(
    private val datasource: WalletDatasource
) : WalletRepositories {
    override fun getWalletInfo(): Flow<UserWalletInfo> = flow {
        emit(datasource.getWalletInfo().toUserWalletInfo())
    }

    override fun getServices(): Flow<List<ServiceItem>> = flow {
        emit(datasource.getServices().map { it.toServiceItem() })
    }

    override fun getPromotions(): Flow<List<Promotion>> = flow {
        emit(datasource.getPromotions().map { it.toPromotion() })
    }

    override fun getNearbyMerchants(): Flow<List<Merchant>> = flow {
        emit(datasource.getNearbyMerchants().map { it.toMerchant() })
    }

    override fun getTransactions(): Flow<List<Transaction>> = flow {
        emit(datasource.getTransactions().map { it.toTransaction() })
    }

    override fun getUserProfile(): Flow<UserProfile> = flow {
        emit(datasource.getUserProfile().toUserProfile())
    }

    override fun getSettingsCategories(): Flow<List<SettingsCategory>> = flow {
        emit(datasource.getSettingsCategories().map { it.toSettingsCategory() })
    }
}
