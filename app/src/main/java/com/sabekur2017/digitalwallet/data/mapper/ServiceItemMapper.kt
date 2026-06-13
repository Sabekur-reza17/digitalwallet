package com.sabekur2017.digitalwallet.data.mapper

import com.sabekur2017.digitalwallet.data.models.ServiceItemDto
import com.sabekur2017.digitalwallet.domain.models.ServiceItem

fun ServiceItemDto.toServiceItem(): ServiceItem {
    return ServiceItem(
        id = id.orEmpty(),
        title = title.orEmpty(),
        iconRes = iconRes ?: 0
    )
}
