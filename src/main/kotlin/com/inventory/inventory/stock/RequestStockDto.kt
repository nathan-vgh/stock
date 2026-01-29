package com.inventory.inventory.stock

import java.time.LocalDate

data class RequestStockDto (
    val quantity: Int,
    val reservedQuantity: Int,
    val lastUpdated: LocalDate,
    val available: Boolean
)