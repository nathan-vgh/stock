package com.inventory.inventory.producer

interface ProducerService {
    fun create(producer: Producer): Producer
    fun delete(id: Long): Unit
    fun getAll(): List<Producer>
    fun getById(id: Long): Producer
    fun update(id: Long, producer: Producer): Producer
}