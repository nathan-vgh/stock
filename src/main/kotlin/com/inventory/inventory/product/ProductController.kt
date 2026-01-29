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

@RestController
@RequestMapping("/products")
class ProductController(private val service: ProductService) {
    @PostMapping
    fun create(@Valid @RequestBody request: RequestProductDto): ResponseEntity<ResponseProductDto> {
        TODO("Not yet implemented")
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        TODO("Not yet implemented")
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<ResponseProductDto>> {
        TODO("Not yet implemented")
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<ResponseProductDto> {
        TODO("Not yet implemented")
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody request: RequestProductDto): ResponseEntity<ResponseProductDto> {
        TODO("Not yet implemented")
    }
}