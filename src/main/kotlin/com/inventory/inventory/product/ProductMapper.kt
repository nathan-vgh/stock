package com.inventory.inventory.product

fun RequestProductDto.toEntity(): Product =
    Product(
        name = name,
        description = description,
        amount = amount
    )

fun Product.toDto(): ResponseProductDto =
    ResponseProductDto(
        id = id,
        name = name,
        description = description,
        amount = amount
    )