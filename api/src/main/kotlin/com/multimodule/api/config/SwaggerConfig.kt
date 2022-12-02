package com.multimodule.api.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("public")
            .pathsToMatch("/partner/**")
            .build()
    }

    @Bean
    fun springApi(): OpenAPI{
        return OpenAPI()
            .info(Info().title("Spring Shop API").version("v1"))

    }
}