package com.sabekur2017.digitalwallet.data.mapper

import com.sabekur2017.digitalwallet.data.models.UserWalletInfoDto
import com.sabekur2017.digitalwallet.domain.models.UserWalletInfo

fun UserWalletInfoDto.toUserWalletInfo(): UserWalletInfo {
    return UserWalletInfo(
        userName = userName.orEmpty(),
        balance = balance ?: 0.0,
        coinReward = coinReward ?: 0.0
    )
}
