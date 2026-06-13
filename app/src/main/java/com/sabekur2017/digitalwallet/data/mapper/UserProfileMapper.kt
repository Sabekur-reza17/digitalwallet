package com.sabekur2017.digitalwallet.data.mapper

import com.sabekur2017.digitalwallet.data.models.UserProfileDto
import com.sabekur2017.digitalwallet.domain.models.UserProfile

fun UserProfileDto.toUserProfile(): UserProfile {
    return UserProfile(
        name = name.orEmpty(),
        email = email.orEmpty(),
        phone = phone.orEmpty(),
        isVerified = isVerified ?: false,
        avatarRes = avatarRes ?: 0
    )
}
