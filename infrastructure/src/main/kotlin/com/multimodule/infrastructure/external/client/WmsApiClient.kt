package com.multimodule.infrastructure.external.client

import com.multimodule.domain.model.Partner
import com.multimodule.domain.repository.PartnerRepository
import org.springframework.stereotype.Component

@Component
class WmsApiClient(
    private val wmsClient: WmsClient
): PartnerRepository {
    override fun getPartner(partnerId: Long): Partner? {
        return wmsClient.getWmsPartner(partnerId).payload
    }
}