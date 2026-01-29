package com.inventory.inventory.product

import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val repository: ProductRepository) : ProductService {
    override fun create(product: Product): Product {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Product> {
        TODO("Not yet implemented")
    }

    override fun getById(): Product? {
        TODO("Not yet implemented")
    }

    override fun update(
        id: Long,
        product: Product
    ): Product {
        TODO("Not yet implemented")
    }
}