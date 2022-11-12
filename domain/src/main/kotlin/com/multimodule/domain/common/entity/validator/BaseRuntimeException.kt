package com.multimodule.domain.common.entity.validator

open class BaseRuntimeException(
    val errorCode: ErrorCode = ErrorCode.USER_BAD_REQUEST_DEFAULT,
    val errorMessage: String
) : RuntimeException()


