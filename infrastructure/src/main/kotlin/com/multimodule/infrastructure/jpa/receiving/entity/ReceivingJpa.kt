package com.multimodule.infrastructure.jpa.receiving.entity

import com.multimodule.infrastructure.jpa.common.BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
class ReceivingJpa(
    @Column(name = "name")
    var name: String,
    @Column(name = "quantity")
    var quantity: Long,
    @Column(name = "price")
    var price: BigDecimal,
    @Column(name = "currency")
    var currency: String,
) : BaseEntity() {
    constructor() : this("", 0,0.toBigDecimal(), "") {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0

}