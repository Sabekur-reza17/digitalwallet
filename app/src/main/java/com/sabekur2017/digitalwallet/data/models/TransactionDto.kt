package com.sabekur2017.digitalwallet.data.models

data class TransactionDto(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val date: String? = null,
    val amount: Double? = null,
    val isIncome: Boolean? = null,
    val status: String? = null,
    val iconRes: Int? = null
)
