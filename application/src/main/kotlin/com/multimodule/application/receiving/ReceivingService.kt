package com.multimodule.application.receiving

import com.multimodule.domain.model.Receiving
import com.multimodule.domain.repository.ReceivingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ReceivingService(
    private val receivingRepository: ReceivingRepository,
) {
    fun create(receiving: Receiving): Receiving {
        return receivingRepository.create(receiving)
    }
}