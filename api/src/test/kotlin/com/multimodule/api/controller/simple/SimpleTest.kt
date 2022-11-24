package com.multimodule.api.controller.simple

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.multimodule.domain.model.Price
import org.junit.jupiter.api.Test
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

@ActiveProfiles("test")
class SimpleTest {
    @Test
    fun typeLengthCheck(){

        // double계산시 오차 발생( 46.68이 나오지 않고 46.68000000000001이 나옴)
        val d1: Double = 12.23
        val d2: Double = 34.45
        println(d1+d2)


        val p1: Price = Price(100.01, "USD")
        val p2: Price = Price(21)
        println(p1 + p2)
        println(p1 - p2)
        println(p1 * p2)
        println(p1 / p2)

    }

    @Test
    fun roundTest(){
        val format = DecimalFormat("#,###.#####")

        val value = BigDecimal("10000.873456789")

        println( format.format(value.setScale(1, RoundingMode.HALF_UP)))

    }


    @Test
    fun jacksonModuleTest(){
        val data = "{\"jobType\": \"RECEIVING_SYNC\"}"
        val obj = jacksonObjectMapper().readValue<Read>(data)
        println(obj)
    }
}

data class Read(
    val jobType: JobType,
    val data: String = ""
)

enum class JobType {
    RECEIVING_SYNC
}