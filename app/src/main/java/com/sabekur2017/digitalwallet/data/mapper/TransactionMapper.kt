package com.sabekur2017.digitalwallet.data.mapper

import com.sabekur2017.digitalwallet.data.models.TransactionDto
import com.sabekur2017.digitalwallet.domain.models.Transaction

fun TransactionDto.toTransaction(): Transaction {
    return Transaction(
        id = id.orEmpty(),
        name = name.orEmpty(),
        description = description.orEmpty(),
        date = date.orEmpty(),
        amount = amount ?: 0.0,
        isIncome = isIncome ?: false,
        status = status.orEmpty(),
        iconRes = iconRes ?: 0
    )
}
