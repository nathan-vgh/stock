package com.inventory.inventory.stock

import com.inventory.inventory.exception.NotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class StockServiceImpl(private val repository: StockRepository): StockService {
    override fun create(stock: Stock): Stock =
        repository.save(stock)

    override fun delete(id: Long) {
        val storedStock = repository.findById(id)
            .orElseThrow { NotFoundException("Stock with $id not found.") }

        repository.delete(storedStock)
    }

    override fun getAll(): List<Stock> =
        repository.findAll()

    override fun getById(id: Long): Stock =
        repository.findById(id)
            .orElseThrow { NotFoundException("Stock with $id not found.") }

    override fun update(id: Long, stock: Stock): Stock {
        val storedStock = repository.findById(id)
            .orElseThrow { NotFoundException("Stock with $id not found.") }

        storedStock.apply {
            quantity = stock.quantity
            reservedQuantity = stock.reservedQuantity
            lastUpdated = stock.lastUpdated
            available = stock.available
        }

        return storedStock
    }
}