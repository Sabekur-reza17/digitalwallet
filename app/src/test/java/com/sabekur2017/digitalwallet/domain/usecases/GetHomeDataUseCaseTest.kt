package com.sabekur2017.digitalwallet.domain.usecases

import app.cash.turbine.test
import com.sabekur2017.digitalwallet.domain.models.*
import com.sabekur2017.digitalwallet.domain.repositories.WalletRepositories
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetHomeDataUseCaseTest {

    private val repository: WalletRepositories = mockk()
    private val useCase = GetHomeDataUseCase(repository)

    @Test
    fun `invoke should combine data from repository`() = runTest {
        // Given
        val walletInfo = UserWalletInfo("User", 100.0, 50.0)
        val services = emptyList<ServiceItem>()
        val promotions = emptyList<Promotion>()
        val merchants = emptyList<Merchant>()

        every { repository.getWalletInfo() } returns flowOf(walletInfo)
        every { repository.getServices() } returns flowOf(services)
        every { repository.getPromotions() } returns flowOf(promotions)
        every { repository.getNearbyMerchants() } returns flowOf(merchants)

        // When
        useCase().test {
            val result = awaitItem()
            
            // Then
            assertEquals(walletInfo, result.walletInfo)
            assertEquals(services, result.services)
            assertEquals(promotions, result.promotions)
            assertEquals(merchants, result.merchants)
            awaitComplete()
        }
    }
}
