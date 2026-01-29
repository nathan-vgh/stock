package com.inventory.inventory.stock

import java.time.LocalDate

data class ResponseStockDto (
    val id: Long,
    val quantity: Int,
    val reservedQuantity: Int,
    val lastUpdated: LocalDate,
    val available: Boolean
)