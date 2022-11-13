package com.multimodule.domain.model

data class Receiving(
    val id: Long,
    val name: String,
    val quantity: Long,
) {
    constructor(name: String, quantity: Long) : this(
        id = 0L,
        name = name,
        quantity = quantity,
    )
}