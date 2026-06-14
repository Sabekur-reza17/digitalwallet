package com.sabekur2017.digitalwallet.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sabekur2017.digitalwallet.domain.usecases.GetProfileDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileDataUseCase: GetProfileDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        onEvent(ProfileEvent.LoadProfile)
    }

    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.LoadProfile -> loadProfileData()
            is ProfileEvent.Logout -> {
            }
        }
    }

    private fun loadProfileData() {
        viewModelScope.launch {
            getProfileDataUseCase()
                .onStart { _uiState.update { it.copy(isLoading = true) } }
                .catch { e -> _uiState.update { it.copy(isLoading = false, error = e.message) } }
                .collect { data ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            userProfile = data.userProfile,
                            settingsCategories = data.settingsCategories
                        )
                    }
                }
        }
    }
}
