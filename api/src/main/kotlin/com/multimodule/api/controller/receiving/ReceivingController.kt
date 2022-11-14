package com.multimodule.api.controller.receiving

import com.multimodule.api.common.model.CommonResponse
import com.multimodule.api.controller.receiving.model.ReceivingRequest
import com.multimodule.api.controller.receiving.model.ReceivingResponse
import com.multimodule.application.receiving.ReceivingProvider
import com.multimodule.domain.model.Receiving
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/receiving")
class ReceivingController(
    private val receivingProvider: ReceivingProvider,
) {
    @GetMapping("")
    fun list(): List<ReceivingResponse> {
        return receivingProvider.receiving().map {
            ReceivingResponse(
                id = it.id,
                name = it.name,
                quantity = it.quantity,
            )
        }
    }

    @PostMapping("")
    fun create(
        @Valid @RequestBody receivingRequest: ReceivingRequest
    ): CommonResponse<ReceivingResponse> {
        val receiving = receivingProvider.create(
            Receiving(
                name = receivingRequest.name,
                quantity = receivingRequest.quantity,
            )
        )
        val receivingResponse =
            ReceivingResponse(id = receiving.id, name = receiving.name, quantity = receiving.quantity)
        return CommonResponse(receivingResponse)
    }
}