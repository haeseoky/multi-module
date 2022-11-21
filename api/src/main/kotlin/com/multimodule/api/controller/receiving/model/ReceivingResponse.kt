package com.multimodule.api.controller.receiving.model

import com.multimodule.domain.model.Price

data class ReceivingResponse (
    val id: Long,
    val name: String,
    val quantity: Long,
    val price: Price
)