package com.sabekur2017.digitalwallet.domain.models

data class UserProfile(
    val name: String,
    val email: String,
    val phone: String,
    val isVerified: Boolean,
    val avatarRes: Int
)
