package com.multimodule.domain.model

data class Receiving(
    val id: Long,
    val name: String,
    val quantity: Long,
    val price: Price,
) {
    constructor(name: String, quantity: Long, price: Price) : this(
        id = 0L,
        name = name,
        quantity = quantity,
        price = price
    )
}