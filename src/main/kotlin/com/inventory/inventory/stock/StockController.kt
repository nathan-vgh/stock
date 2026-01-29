package com.inventory.inventory.stock

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
@RequestMapping("/stocks")
class StockController(private val service: StockService) {
    @PostMapping
    fun create(@Valid @RequestBody request: RequestStockDto): ResponseEntity<ResponseStockDto> {
        val createdStock = service.create(request.toEntity())

        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdStock.id)
            .toUri()

        return ResponseEntity.created(location).body(createdStock.toDto())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<ResponseStockDto> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<ResponseStockDto>> {
        val stocks = service.getAll()
        val stocksDto = stocks.map(Stock::toDto)
        return ResponseEntity.ok(stocksDto)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<ResponseStockDto> {
        val stock = service.getById(id)
        return ResponseEntity.ok(stock.toDto())
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody request: RequestStockDto): ResponseEntity<ResponseStockDto> {
        val updatedStock = service.update(id, request.toEntity())
        return ResponseEntity.ok(updatedStock.toDto())
    }
}