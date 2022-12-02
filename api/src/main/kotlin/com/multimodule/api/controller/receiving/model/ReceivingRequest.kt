package com.multimodule.api.controller.receiving.model


import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal

@Schema(name = "ReceivingRequest", description = "Receiving Request")
class ReceivingRequest(
    @Schema(description = "이름", example = "상품1")
    val name: String,
    @Schema(description = "수량")
    val quantity: Long,
    @Schema(description = "가격")
    val price: BigDecimal,
    @Schema(description = "통화")
    val currency: String,
)