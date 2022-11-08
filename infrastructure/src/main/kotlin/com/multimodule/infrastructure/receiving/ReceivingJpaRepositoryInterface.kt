package com.multimodule.infrastructure.receiving

import com.multimodule.domain.entity.ReceivingTest
import org.springframework.data.jpa.repository.JpaRepository


interface ReceivingJpaRepositoryInterface: JpaRepository<ReceivingTest, Long> {
}