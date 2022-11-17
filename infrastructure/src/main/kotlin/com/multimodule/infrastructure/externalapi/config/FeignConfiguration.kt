package com.multimodule.infrastructure.externalapi.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["com.multimodule"])
class FeignConfiguration {
}