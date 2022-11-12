package com.multimodule.api.error

data class ExceptionResponse(
    val serviceCode: String,
    val errorCode: Int,
    val errorMessage: String
)