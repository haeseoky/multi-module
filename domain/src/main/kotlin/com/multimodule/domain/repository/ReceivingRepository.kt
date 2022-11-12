package com.multimodule.domain.repository

import com.multimodule.domain.model.Receiving
import org.springframework.stereotype.Repository

@Repository
interface ReceivingRepository {
    fun findAll(): List<Receiving>
}