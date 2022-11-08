package com.multimodule.domain.entity

import javax.persistence.*

@Entity
class ReceivingTest() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0

}