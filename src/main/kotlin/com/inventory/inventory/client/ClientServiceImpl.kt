package com.inventory.inventory.client

import org.springframework.stereotype.Service

@Service
class ClientServiceImpl(private val repository: ClientRepository) : ClientService {
    override fun create(client: Client): Client {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Client> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long): Client {
        TODO("Not yet implemented")
    }

    override fun update(
        id: Long,
        client: Client
    ): Client {
        TODO("Not yet implemented")
    }

}