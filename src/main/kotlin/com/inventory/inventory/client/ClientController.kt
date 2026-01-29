package com.inventory.inventory.client

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
@RequestMapping("/clients")
class ClientController (private val service: ClientService) {
    @PostMapping
    fun create(@Valid @RequestBody request: RequestClientDto): ResponseEntity<ResponseClientDto> {
        val createdClient = service.create(request.toEntity())

        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdClient.id)
            .toUri()

        return ResponseEntity.created(location).body(createdClient.toDto())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<ResponseClientDto>> {
        val clients = service.getAll()
        val clientsDto = clients.map(Client::toDto)
        return ResponseEntity.ok(clientsDto)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<ResponseClientDto> {
        val client = service.getById(id)
        return ResponseEntity.ok(client.toDto())
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody request: RequestClientDto): ResponseEntity<ResponseClientDto> {
        val updatedClient = service.update(id, request.toEntity())
        return ResponseEntity.ok(updatedClient.toDto())
    }
}