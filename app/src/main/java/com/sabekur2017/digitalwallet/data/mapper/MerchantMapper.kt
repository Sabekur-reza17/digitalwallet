package com.sabekur2017.digitalwallet.data.mapper

import com.sabekur2017.digitalwallet.data.models.MerchantDto
import com.sabekur2017.digitalwallet.domain.models.Merchant

fun MerchantDto.toMerchant(): Merchant {
    return Merchant(
        id = id.orEmpty(),
        name = name.orEmpty(),
        category = category.orEmpty(),
        distance = distance.orEmpty(),
        rating = rating ?: 0.0,
        logoRes = logoRes ?: 0
    )
}
