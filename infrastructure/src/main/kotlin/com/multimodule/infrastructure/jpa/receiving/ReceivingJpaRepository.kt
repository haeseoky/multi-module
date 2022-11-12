package com.multimodule.infrastructure.jpa.receiving

import com.multimodule.domain.model.Receiving
import com.multimodule.domain.repository.ReceivingRepository
import org.springframework.stereotype.Component

@Component
class ReceivingJpaRepository(
    private val receivingJpaRepositoryInterface: ReceivingJpaRepositoryInterface
): ReceivingRepository {
    override fun findAll(): List<Receiving> {
        return receivingJpaRepositoryInterface.findAll().map {
            Receiving(
                id = it.id, quantity = it.quantity,
            )
        }
    }
}