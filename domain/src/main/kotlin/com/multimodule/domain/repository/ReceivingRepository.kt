package com.multimodule.domain.repository

import com.multimodule.domain.entity.ReceivingTest
import org.springframework.stereotype.Repository

@Repository
interface ReceivingRepository {
    fun findAll(): List<ReceivingTest>
}