package com.sabekur2017.digitalwallet.presentation.home

import app.cash.turbine.test
import com.sabekur2017.digitalwallet.domain.models.HomeData
import com.sabekur2017.digitalwallet.domain.models.UserWalletInfo
import com.sabekur2017.digitalwallet.domain.usecases.GetHomeDataUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel
    private val getHomeDataUseCase: GetHomeDataUseCase = mockk()
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadHomeData should update uiState with home data`() = runTest {
        // Given
        val homeData = HomeData(
            walletInfo = UserWalletInfo("User", 100.0, 50.0),
            services = emptyList(),
            promotions = emptyList(),
            merchants = emptyList()
        )
        coEvery { getHomeDataUseCase() } returns flowOf(homeData)

        // When
        viewModel = HomeViewModel(getHomeDataUseCase)

        // Then
        viewModel.uiState.test {
            var state = awaitItem()
            
            if (state.walletInfo == null) {
                state = awaitItem() // onStart
                if (state.isLoading) {
                    state = awaitItem() // collect
                }
            }

            assertEquals(homeData.walletInfo, state.walletInfo)
            assertEquals(false, state.isLoading)
        }
    }
}
