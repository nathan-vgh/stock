package com.inventory.inventory.client

fun RequestClientDto.toEntity() : Client =
    Client(
        username = username,
        email = email,
        password = password,
        age = age
    )

fun Client.toDto() : ResponseClientDto =
    ResponseClientDto(
        id = id,
        username = username,
        email = email,
        age = age
    )