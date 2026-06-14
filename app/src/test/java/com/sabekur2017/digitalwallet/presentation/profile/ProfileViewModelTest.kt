package com.sabekur2017.digitalwallet.presentation.profile

import app.cash.turbine.test
import com.sabekur2017.digitalwallet.domain.models.ProfileData
import com.sabekur2017.digitalwallet.domain.models.UserProfile
import com.sabekur2017.digitalwallet.domain.usecases.GetProfileDataUseCase
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
class ProfileViewModelTest {

    private lateinit var viewModel: ProfileViewModel
    private val getProfileDataUseCase: GetProfileDataUseCase = mockk()
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
    fun `LoadProfile event should update uiState with user profile and categories`() = runTest {
        // Given
        val userProfile = UserProfile("Name", "Email", "Phone", true, 0)
        val profileData = ProfileData(userProfile, emptyList())
        coEvery { getProfileDataUseCase() } returns flowOf(profileData)

        // When
        viewModel = ProfileViewModel(getProfileDataUseCase)

        // Then
        viewModel.uiState.test {
            var state = awaitItem()
            
            if (state.userProfile == null) {
                state = awaitItem() // onStart
                if (state.isLoading) {
                    state = awaitItem() // collect
                }
            }

            assertEquals(userProfile, state.userProfile)
            assertEquals(emptyList<com.sabekur2017.digitalwallet.domain.models.SettingsCategory>(), state.settingsCategories)
            assertEquals(false, state.isLoading)
        }
    }
}
