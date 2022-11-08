package com.multimodule.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan("com.multimodule")
@EnableJpaRepositories("com.multimodule")
@EntityScan(value = ["com.multimodule"])
class ApiApplication {
}

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}