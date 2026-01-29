package com.inventory.inventory.producer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProducerRepository : JpaRepository<Producer, Long>