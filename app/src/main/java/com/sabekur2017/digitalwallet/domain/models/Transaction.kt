package com.sabekur2017.digitalwallet.domain.models

data class Transaction(
    val id: String,
    val name: String,
    val description: String,
    val date: String,
    val amount: Double,
    val isIncome: Boolean,
    val status: String,
    val iconRes: Int
)
