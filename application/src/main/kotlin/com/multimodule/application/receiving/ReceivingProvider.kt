package com.multimodule.application.receiving

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ReceivingProvider {
    fun receiving(): String {
        return "receiving"
    }
}