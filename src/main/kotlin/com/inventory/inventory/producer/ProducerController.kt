package com.inventory.inventory.producer

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
@RequestMapping("/producers")
class ProducerController(private val service: ProducerService) {
    @PostMapping
    fun create(@Valid @RequestBody request: RequestProducerDto): ResponseEntity<ResponseProducerDto> {
        TODO("Not yet implemented")
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        TODO("Not yet implemented")
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<ResponseProducerDto>> {
        TODO("Not yet implemented")
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<ResponseProducerDto> {
        TODO("Not yet implemented")
    }

    @PutMapping
    fun update(@PathVariable id: Long, @Valid @RequestBody request: RequestProducerDto): ResponseEntity<ResponseProducerDto> {
        TODO("Not yet implemented")
    }
}