package com.sabekur2017.digitalwallet.domain.models

data class Merchant(
    val id: String,
    val name: String,
    val category: String,
    val distance: String,
    val rating: Double,
    val logoRes: Int
)
