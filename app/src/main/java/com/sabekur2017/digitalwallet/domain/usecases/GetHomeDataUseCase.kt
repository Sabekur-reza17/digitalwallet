package com.sabekur2017.digitalwallet.domain.usecases

import com.sabekur2017.digitalwallet.domain.models.*
import com.sabekur2017.digitalwallet.domain.repositories.WalletRepositories
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(
    private val repository: WalletRepositories
) {
    operator fun invoke(): Flow<HomeData> {
        return combine(
            repository.getWalletInfo(),
            repository.getServices(),
            repository.getPromotions(),
            repository.getNearbyMerchants()
        ) { walletInfo, services, promotions, merchants ->
            HomeData(walletInfo, services, promotions, merchants)
        }
    }
}
