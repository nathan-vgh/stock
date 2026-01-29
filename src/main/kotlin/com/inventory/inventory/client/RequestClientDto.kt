package com.inventory.inventory.client

data class RequestClientDto (
    val username: String,
    val email: String,
    val password: String,
    val age: Int
)