package com.multimodule.domain.common.entity.validator

enum class ErrorCode(val value: Int, val message: String) {
    USER_BAD_REQUEST_DEFAULT(1, "잘못된 호출입니다."),
    VALIDATE_ERROR(3, "유효하지 않은 값입니다."),
    NO_ELEMENT(4,  "아이템이 존재하지 않습니다."),
}