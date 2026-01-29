package com.inventory.inventory.producer

fun RequestProducerDto.toEntity (): Producer =
    Producer(
        name = name,
        email = email,
        location = location
    )

fun Producer.toDto (): ResponseProducerDto =
    ResponseProducerDto(
        id = id,
        name = name,
        email = email,
        location = location
    )