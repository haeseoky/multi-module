package com.multimodule.domain.model

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

data class Price(
    val value: BigDecimal,
    val currency: String
) {
    constructor(value: Double, currency: String = "원") : this(value.toBigDecimal(), currency)
    constructor(value: Long, currency: String = "원") : this(value.toBigDecimal(), currency)
    constructor(value: Int, currency: String = "원") : this(value.toBigDecimal(), currency)
    constructor(value: String, currency: String = "원") : this(value.toBigDecimal(), currency)

    operator fun plus(price: Price): Price {
        return Price(value + price.value, currency)
    }

    operator fun minus(price: Price): Price {
        return Price(value - price.value, currency)
    }

    operator fun times(price: Price): Price {
        return Price(value * price.value, currency)
    }

    operator fun div(price: Price): Price {
        if (price.value == BigDecimal.ZERO) {
            throw ArithmeticException("Divide by zero")
        }
        return Price(value / price.value, currency)
    }

    override fun toString(): String {
        return formatter.format(value.setScale(scale, roundingMode))
    }

    fun toStringWithCurrency(): String {
        return "${formatter.format(value.setScale(scale, roundingMode))} $currency"
    }

    // format 1,000.00000
    companion object {
        private val formatter = DecimalFormat("#,###.#####")
        private val roundingMode = RoundingMode.HALF_UP
        private const val scale = 0
    }
}