package com.inventory.inventory.producer

import org.springframework.stereotype.Service

@Service
class ProducerServiceImpl(private val repository: ProducerRepository) : ProducerService {
    override fun create(producer: Producer): Producer {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Producer> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long): Producer? {
        TODO("Not yet implemented")
    }

    override fun update(
        id: Long,
        producer: Producer
    ): Producer {
        TODO("Not yet implemented")
    }
}