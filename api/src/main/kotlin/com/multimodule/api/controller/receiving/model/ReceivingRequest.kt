package com.multimodule.api.controller.receiving.model

import io.swagger.annotations.ApiModelProperty
import java.math.BigDecimal

class ReceivingRequest(
    @ApiModelProperty(value = "이름")
    val name: String,
    @ApiModelProperty(value = "수량")
    val quantity: Long,
    @ApiModelProperty(value = "가격")
    val price: BigDecimal,
    @ApiModelProperty(value = "통화")
    val currency: String,
)