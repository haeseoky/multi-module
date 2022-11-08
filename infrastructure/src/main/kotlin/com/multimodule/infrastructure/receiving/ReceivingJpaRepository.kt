package com.multimodule.infrastructure.receiving

import com.multimodule.domain.entity.ReceivingTest
import com.multimodule.domain.repository.ReceivingRepository
import org.springframework.stereotype.Component

@Component
class ReceivingJpaRepository(
    private val receivingJpaRepositoryInterface: ReceivingJpaRepositoryInterface
): ReceivingRepository {
    override fun findAll(): List<ReceivingTest> {
        return receivingJpaRepositoryInterface.findAll()
    }
}