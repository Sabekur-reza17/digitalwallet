package com.sabekur2017.digitalwallet.domain.usecases

import com.sabekur2017.digitalwallet.domain.models.Transaction
import com.sabekur2017.digitalwallet.domain.repositories.WalletRepositories
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTransactionsUseCase @Inject constructor(
    private val repository: WalletRepositories
) {
    operator fun invoke(): Flow<List<Transaction>> {
        return repository.getTransactions()
    }
}
