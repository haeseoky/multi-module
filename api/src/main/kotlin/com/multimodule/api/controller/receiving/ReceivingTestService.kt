package com.multimodule.api.controller.receiving

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ReceivingTestService(
    private val receivingTestRepository: ReceivingTestRepository,
) {
    fun test(){
        println("haeseoky ReceivingTestService run")
        receivingTestRepository.test()
    }
}