package com.multimodule.domain.repository

import com.multimodule.domain.entity.ReceivingTest

interface ReceivingRepository {
    fun findAll(): List<ReceivingTest>
}