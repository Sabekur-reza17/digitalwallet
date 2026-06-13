package com.sabekur2017.digitalwallet.data.mapper

import com.sabekur2017.digitalwallet.data.models.PromotionDto
import com.sabekur2017.digitalwallet.domain.models.Promotion

fun PromotionDto.toPromotion(): Promotion {
    return Promotion(
        id = id.orEmpty(),
        title = title.orEmpty(),
        imageRes = imageRes ?: 0
    )
}
