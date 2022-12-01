package com.multimodule.api.controller.receiving

import org.springframework.stereotype.Repository

@Repository
class ReceivingTestRepository {
    fun test(): String{
        println("haeseoky ReceivingTestRepository run")
        return "return ReceivingTestRepository"
    }
}