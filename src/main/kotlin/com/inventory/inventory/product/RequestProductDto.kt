package com.inventory.inventory.product

data class RequestProductDto (
    val name: String,
    val description: String,
    val amount: Double
)