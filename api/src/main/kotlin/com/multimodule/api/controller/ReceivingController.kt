package com.multimodule.api.controller

import com.multimodule.application.receiving.ReceivingProvider
import com.multimodule.domain.entity.ReceivingTest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ReceivingController (
    private val receivingProvider: ReceivingProvider,
        ) {
    @GetMapping("/receiving")
    fun receiving(): List<ReceivingTest> {
        return receivingProvider.receiving()
    }
}