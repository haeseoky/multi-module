package com.multimodule.infrastructure.jpa.receiving.entity

import com.multimodule.infrastructure.jpa.common.BaseEntity
import javax.persistence.*

@Entity
class ReceivingJpa(
    @Column(name = "name")
    var name: String,
    @Column(name = "quantity")
    var quantity: Long,

) : BaseEntity() {
    constructor() : this("", 0) {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0

}