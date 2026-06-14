package com.sabekur2017.digitalwallet.presentation.history

import app.cash.turbine.test
import com.sabekur2017.digitalwallet.domain.models.Transaction
import com.sabekur2017.digitalwallet.domain.usecases.GetTransactionsUseCase
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
class HistoryViewModelTest {

    private lateinit var viewModel: HistoryViewModel
    private val getTransactionsUseCase: GetTransactionsUseCase = mockk()
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
    fun `LoadTransactions event should update uiState with transactions`() = runTest {
        // Given
        val transactions = listOf(
            Transaction("1", "Test", "Desc", "Date", 10.0, true, "Success", 0)
        )
        coEvery { getTransactionsUseCase() } returns flowOf(transactions)

        // When
        viewModel = HistoryViewModel(getTransactionsUseCase)

        // Then
        viewModel.uiState.test {
            // Initial state
            var state = awaitItem()
            
            // Depending on how fast init runs, we might need to wait for the loaded state
            if (state.transactions.isEmpty()) {
                state = awaitItem() // State from onStart (isLoading = true)
                if (state.isLoading) {
                   state = awaitItem() // State from collect (isLoading = false, transactions = ...)
                }
            }

            assertEquals(transactions, state.transactions)
            assertEquals(false, state.isLoading)
        }
    }

    @Test
    fun `SearchTransactions event should update searchQuery in uiState`() = runTest {
        // Given
        coEvery { getTransactionsUseCase() } returns flowOf(emptyList())
        viewModel = HistoryViewModel(getTransactionsUseCase)

        // When
        val query = "search query"
        viewModel.onEvent(HistoryEvent.SearchTransactions(query))

        // Then
        viewModel.uiState.test {
            val state = awaitItem()
            assertEquals(query, state.searchQuery)
        }
    }
}
