package com.sabekur2017.digitalwallet.domain.usecases

import com.sabekur2017.digitalwallet.domain.models.*
import com.sabekur2017.digitalwallet.domain.repositories.WalletRepositories
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetProfileDataUseCase @Inject constructor(
    private val repository: WalletRepositories
) {
    operator fun invoke(): Flow<ProfileData> {
        return combine(
            repository.getUserProfile(),
            repository.getSettingsCategories()
        ) { profile, categories ->
            ProfileData(profile, categories)
        }
    }
}
