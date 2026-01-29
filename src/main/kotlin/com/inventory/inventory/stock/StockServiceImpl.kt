package com.inventory.inventory.stock

import org.springframework.stereotype.Service

@Service
class StockServiceImpl(private val repository: StockRepository): StockService {
    override fun create(stock: Stock): Stock {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Stock> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long): Stock {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, stock: Stock) {
        TODO("Not yet implemented")
    }
}