package com.multimodule.infrastructure.jpa.receiving

import com.multimodule.domain.model.Receiving
import com.multimodule.domain.repository.ReceivingRepository
import com.multimodule.infrastructure.jpa.receiving.entity.ReceivingJpa
import org.springframework.stereotype.Component

@Component
class ReceivingJpaRepository(
    private val receivingJpaRepositoryInterface: ReceivingJpaRepositoryInterface
) : ReceivingRepository {
    override fun findAll(): List<Receiving> {
        return receivingJpaRepositoryInterface.findAll().map {
            Receiving(
                name = it.name, quantity = it.quantity,
            )
        }
    }

    override fun create(receiving: Receiving): Receiving {
        val receivingJpa = receivingJpaRepositoryInterface.save(
            ReceivingJpa(
                name = receiving.name, quantity = receiving.quantity,
            )
        )
        return Receiving(
            id = receivingJpa.id,
            name = receivingJpa.name,
            quantity = receivingJpa.quantity
        )
    }
}