package com.inventory.inventory.product

data class ResponseProductDto (
    val id: Long,
    val name: String,
    val description: String,
    val amount: Double
)