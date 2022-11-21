package com.multimodule.api.common.model

import org.springframework.core.MethodParameter
import org.springframework.core.io.ByteArrayResource
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

@RestControllerAdvice
class ResponseHandler : ResponseBodyAdvice<Any>{
    override fun supports(
        returnType: MethodParameter,
        converterType: Class<out HttpMessageConverter<*>>
    ): Boolean {
        return true
    }

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        return if (body != null
            && (body is ExceptionResponse
                    || body is CommonResponse<*>
                    || body is ByteArrayResource
                    || request.uri.path.contains("swagger")
                    || request.uri.path.contains("api-docs")
                    || request.uri.path.contains("prometheus"))
        ) {
            body
        } else {
            CommonResponse(payload = body)
        }
    }

}