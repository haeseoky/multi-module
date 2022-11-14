package com.multimodule.infrastructure.external.client

import com.multimodule.domain.model.Partner
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "wms", url = "\${sfn.wms.url}")
interface WmsClient {
    @GetMapping("wms-partner")
    fun getWmsPartner(
        @RequestParam(required = true) partnerId: Long,
    ): CommonResponse<Partner>
}

class CommonResponse<T> (
    val payload: T? = null,
)
