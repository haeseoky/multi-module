package com.multimodule.api.controller.receiving.model

import io.swagger.annotations.ApiModelProperty

class ReceivingRequest(
    @ApiModelProperty(value = "이름")
    val name: String,
    @ApiModelProperty(value = "수량")
    val quantity: Long,
)