package com.multimodule.application.receiving

import com.multimodule.domain.entity.ReceivingTest
import com.multimodule.domain.repository.ReceivingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ReceivingProvider(
    private val receivingRepository: ReceivingRepository,
) {
    fun receiving(): List<ReceivingTest> {
        return receivingRepository.findAll()
    }
}