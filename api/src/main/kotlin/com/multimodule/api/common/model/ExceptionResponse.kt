package com.multimodule.api.common.model

data class ExceptionResponse(
    val serviceCode: String,
    val errorCode: Int,
    val errorMessage: String
)