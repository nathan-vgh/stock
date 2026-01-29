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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/producers")
class ProducerController(private val service: ProducerService) {
    @PostMapping
    fun create(@Valid @RequestBody request: RequestProducerDto): ResponseEntity<ResponseProducerDto> {
        val createdProducer = service.create(request.toEntity())

        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdProducer.id)
            .toUri()

        return ResponseEntity.created(location).body(createdProducer.toDto())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<ResponseProducerDto>> {
        val producers = service.getAll()
        val producersDto = producers.map(Producer::toDto)
        return ResponseEntity.ok(producersDto)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<ResponseProducerDto> {
        val producer = service.getById(id)
        return ResponseEntity.ok(producer.toDto())
    }

    @PutMapping
    fun update(@PathVariable id: Long, @Valid @RequestBody request: RequestProducerDto): ResponseEntity<ResponseProducerDto> {
        val updatedProducer = service.update(id, request.toEntity())
        return ResponseEntity.ok(updatedProducer.toDto())
    }
}