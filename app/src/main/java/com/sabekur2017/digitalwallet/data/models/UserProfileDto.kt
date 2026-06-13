package com.sabekur2017.digitalwallet.data.models

data class UserProfileDto(
    val name: String? = null,
    val email: String? = null,
    val phone: String? = null,
    val isVerified: Boolean? = null,
    val avatarRes: Int? = null
)
