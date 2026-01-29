package com.inventory.inventory.stock

fun RequestStockDto.toEntity(): Stock =
    Stock(
        quantity = quantity,
        reservedQuantity = reservedQuantity,
        lastUpdated = lastUpdated,
        available = available
    )

fun Stock.toDto(): ResponseStockDto =
    ResponseStockDto(
        id = id,
        quantity = quantity,
        reservedQuantity = reservedQuantity,
        lastUpdated = lastUpdated,
        available = available
    )