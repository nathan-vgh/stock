package com.inventory.inventory.product

import com.inventory.inventory.exception.NotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class ProductServiceImpl(private val repository: ProductRepository) : ProductService {
    override fun create(product: Product): Product =
        repository.save(product)

    override fun delete(id: Long) {
        val storedProduct = repository.findById(id)
            .orElseThrow { NotFoundException("Product with $id not found.") }

        repository.delete(storedProduct)
    }

    override fun getAll(): List<Product> =
        repository.findAll()

    override fun getById(id: Long): Product =
        repository.findById(id)
            .orElseThrow { NotFoundException("Product with $id not found.") }

    override fun update(id: Long, product: Product): Product {
        val storedProduct = repository.findById(id)
            .orElseThrow { NotFoundException("Product with $id not found.") }

        storedProduct.apply {
            name = product.name
            description = product.description
            amount = product.amount
        }

        return storedProduct
    }
}