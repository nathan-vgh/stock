package com.inventory.inventory.client

import com.inventory.inventory.exception.NotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class ClientServiceImpl(private val repository: ClientRepository) : ClientService {
    override fun create(client: Client): Client =
        repository.save(client)

    override fun delete(id: Long) {
        val storedClient = repository.findById(id)
            .orElseThrow { NotFoundException("Client with $id not found.") }

        repository.delete(storedClient)
    }

    override fun getAll(): List<Client> =
        repository.findAll()

    override fun getById(id: Long): Client =
        repository.findById(id)
            .orElseThrow { NotFoundException("Client with $id not found.") }

    override fun update(id: Long, client: Client): Client {
        val storedClient = repository.findById(id)
            .orElseThrow { NotFoundException("Client with $id not found.") }

        storedClient.apply {
            username = client.username
            email = client.email
            password = client.password
            age = client.age
        }

        return storedClient
    }
}