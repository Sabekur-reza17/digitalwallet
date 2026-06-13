package com.sabekur2017.digitalwallet.domain.models

data class ProfileData(
    val userProfile: UserProfile,
    val settingsCategories: List<SettingsCategory>
)
