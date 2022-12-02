package com.multimodule.api.controller.receiving

import com.multimodule.api.controller.receiving.model.ReceivingRequest
import com.multimodule.api.controller.receiving.model.ReceivingResponse
import com.multimodule.application.receiving.ReceivingProvider
import com.multimodule.application.receiving.ReceivingService
import com.multimodule.domain.model.Price
import com.multimodule.domain.model.Receiving
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/receiving")
class ReceivingController(
    private val receivingProvider: ReceivingProvider,
    private val receivingService: ReceivingService,
) {
    @GetMapping("")
    fun list(): List<ReceivingResponse> {
        return receivingProvider.receiving().map {
            ReceivingResponse(
                id = it.id,
                name = it.name,
                quantity = it.quantity,
                price = it.price,
            )
        }
    }

    @PostMapping("")
    fun create(
        @Valid @RequestBody receivingRequest: ReceivingRequest
    ): ReceivingResponse {
        val receiving = receivingService.create(
            Receiving(
                name = receivingRequest.name,
                quantity = receivingRequest.quantity,
                price = Price(receivingRequest.price, receivingRequest.currency)
            )
        )
        return ReceivingResponse(
            id = receiving.id,
            name = receiving.name,
            quantity = receiving.quantity,
            price = receiving.price,
        )
    }
}