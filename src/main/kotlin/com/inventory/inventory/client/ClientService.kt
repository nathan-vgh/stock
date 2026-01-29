package com.inventory.inventory.client

interface ClientService {
    fun create(client: Client): Client
    fun delete(id: Long): Unit
    fun getAll(): List<Client>
    fun getById(id: Long): Client?
    fun update(id: Long, client: Client): Client
}