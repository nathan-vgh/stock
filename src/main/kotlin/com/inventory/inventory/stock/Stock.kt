package com.inventory.inventory.stock

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "stock")
class Stock (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var quantity: Int,
    var reservedQuantity: Int,
    var lastUpdated: LocalDate,
    var available: Boolean
)