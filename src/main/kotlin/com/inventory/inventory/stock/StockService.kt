package com.inventory.inventory.stock

interface StockService {
    fun create(stock: Stock): Stock
    fun delete(id: Long): Unit
    fun getAll(): List<Stock>
    fun getById(id: Long): Stock
    fun update(id: Long, stock: Stock)
}