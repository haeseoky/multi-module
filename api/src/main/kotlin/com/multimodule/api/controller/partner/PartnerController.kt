package com.multimodule.api.controller.partner

import com.multimodule.application.partner.PartnerProvider
import com.multimodule.domain.model.Partner
import com.multimodule.infrastructure.externalapi.client.CommonResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/partner")
class PartnerController(
    private val partnerProvider: PartnerProvider,
) {
    @GetMapping("/{id}")
    fun getPartner(@PathVariable id: Long): CommonResponse<Partner> {
        return CommonResponse(partnerProvider.getPartner(id))
    }
}