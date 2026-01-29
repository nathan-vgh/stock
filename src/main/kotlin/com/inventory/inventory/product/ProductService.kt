package com.inventory.inventory.product

interface ProductService {
    fun create(product: Product): Product
    fun delete(id: Long): Unit
    fun getAll(): List<Product>
    fun getById(id: Long): Product
    fun update(id: Long, product: Product): Product
}