package com.multimodule.application.partner

import com.multimodule.domain.model.Partner
import com.multimodule.domain.repository.PartnerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PartnerProvider(
    private val partnerRepository: PartnerRepository,
) {
    fun getPartner(partnerId: Long): Partner? {
        return partnerRepository.getPartner(partnerId)
    }
}