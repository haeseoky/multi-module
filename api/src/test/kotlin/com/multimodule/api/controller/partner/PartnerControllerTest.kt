package com.multimodule.api.controller.partner

import com.multimodule.api.controller.base.AbstractSpringBootTest
import org.junit.jupiter.api.Test
import org.springframework.boot.test.web.client.TestRestTemplate

internal class PartnerControllerTest(
    private val restTemplate: TestRestTemplate,
) : AbstractSpringBootTest() {
    @Test
    fun getPartner() {
        val url = "http://localhost:$serverPort/partner/3"
        val result = restTemplate.getForObject(url, String::class.java)

        println(result)

    }
}