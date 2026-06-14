package com.sabekur2017.digitalwallet.presentation.profile

import com.sabekur2017.digitalwallet.domain.models.SettingsCategory
import com.sabekur2017.digitalwallet.domain.models.UserProfile

data class ProfileUiState(
    val isLoading: Boolean = false,
    val userProfile: UserProfile? = null,
    val settingsCategories: List<SettingsCategory> = emptyList(),
    val error: String? = null
)
