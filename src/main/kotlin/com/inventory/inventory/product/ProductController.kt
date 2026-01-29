package com.inventory.inventory.product

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/products")
class ProductController(private val service: ProductService) {
    @PostMapping
    fun create(@Valid @RequestBody request: RequestProductDto): ResponseEntity<ResponseProductDto> {
        val createdProduct = service.create(request.toEntity())

        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdProduct.id)
            .toUri()

        return ResponseEntity.created(location).body(createdProduct.toDto())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<ResponseProductDto>> {
        val products = service.getAll()
        val productsDto = products.map(Product::toDto)
        return ResponseEntity.ok(productsDto)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<ResponseProductDto> {
        val product = service.getById(id)
        return ResponseEntity.ok(product.toDto())
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody request: RequestProductDto): ResponseEntity<ResponseProductDto> {
        val updatedProduct = service.update(id, request.toEntity())
        return ResponseEntity.ok(updatedProduct.toDto())
    }
}