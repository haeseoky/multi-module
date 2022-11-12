package com.multimodule.infrastructure.jpa.receiving

import com.multimodule.infrastructure.jpa.receiving.entity.ReceivingJpa
import org.springframework.data.jpa.repository.JpaRepository


interface ReceivingJpaRepositoryInterface: JpaRepository<ReceivingJpa, Long> {
}