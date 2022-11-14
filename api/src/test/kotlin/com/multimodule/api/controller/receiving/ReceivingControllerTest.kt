package com.multimodule.api.controller.receiving

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.multimodule.api.controller.base.AbstractSpringBootTest
import com.multimodule.api.controller.receiving.model.ReceivingRequest
import com.multimodule.infrastructure.jpa.receiving.ReceivingJpaRepositoryInterface
import com.multimodule.infrastructure.jpa.receiving.entity.ReceivingJpa
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.web.client.TestRestTemplate

internal class ReceivingControllerTest(
    private val restTemplate: TestRestTemplate,
    private val receivingJpaRepositoryInterface: ReceivingJpaRepositoryInterface
) : AbstractSpringBootTest() {

    @Test
    fun list() {
        receivingJpaRepositoryInterface.save(
            ReceivingJpa(
                name = "test",
                quantity = 1,
            )
        )

        val url = "http://localhost:$serverPort/receiving"
        val result = restTemplate.getForObject(url, Collection::class.java)
        println(result.forEach { println(it) })
        Assertions.assertThat(result.size).isGreaterThan(0)
    }

    @Test
    fun create(){
        val url = "http://localhost:$serverPort/receiving"
        val receivingRequest = ReceivingRequest(
            name = "test",
            quantity = 1,
        )
        val result = restTemplate.postForObject(url, receivingRequest, String::class.java)
        println(result)
        jacksonObjectMapper().readTree(result).let {
            Assertions.assertThat(it.get("payload").get("name").asText()).isEqualTo("test")
            Assertions.assertThat(it.get("payload").get("quantity").asInt()).isEqualTo(1)
        }
    }
}