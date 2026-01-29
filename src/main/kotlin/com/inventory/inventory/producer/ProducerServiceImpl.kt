package com.inventory.inventory.producer

import com.inventory.inventory.exception.NotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class ProducerServiceImpl(private val repository: ProducerRepository) : ProducerService {
    override fun create(producer: Producer): Producer =
        repository.save(producer)

    override fun delete(id: Long) {
        val storedProducer = repository.findById(id)
            .orElseThrow { NotFoundException("Producer with $id not found.") }

        repository.delete(storedProducer)
    }

    override fun getAll(): List<Producer> =
        repository.findAll()

    override fun getById(id: Long): Producer =
        repository.findById(id)
            .orElseThrow { NotFoundException("Producer with $id not found.") }

    override fun update(id: Long, producer: Producer): Producer {
        val storedProducer = repository.findById(id)
            .orElseThrow { NotFoundException("Producer with $id not found.") }

        storedProducer.apply {
            name = producer.name
            email = producer.email
            location = producer.location
        }

        return storedProducer
    }
}