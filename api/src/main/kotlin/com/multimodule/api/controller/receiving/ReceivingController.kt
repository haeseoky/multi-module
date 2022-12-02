package com.multimodule.api.controller.receiving

import com.multimodule.api.controller.receiving.model.ReceivingRequest
import com.multimodule.api.controller.receiving.model.ReceivingResponse
import com.multimodule.application.receiving.ReceivingProvider
import com.multimodule.application.receiving.ReceivingService
import com.multimodule.domain.model.Price
import com.multimodule.domain.model.Receiving
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@Tag(name = "Receiving", description = "Receiving API")
@RestController
@RequestMapping("/receiving")
class ReceivingController(
    private val receivingProvider: ReceivingProvider,
    private val receivingService: ReceivingService,
) {
    @Operation(summary = "Receiving 조회")
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

    @Operation(summary = "Receiving 생성")
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