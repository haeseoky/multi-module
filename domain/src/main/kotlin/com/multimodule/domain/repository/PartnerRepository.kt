package com.multimodule.domain.repository

import com.multimodule.domain.model.Partner
import org.springframework.stereotype.Repository

@Repository
interface PartnerRepository {
    fun getPartner(partnerId: Long): Partner?
}