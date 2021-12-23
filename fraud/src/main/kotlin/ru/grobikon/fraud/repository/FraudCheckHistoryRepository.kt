package ru.grobikon.fraud.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.grobikon.fraud.model.FraudCheckHistory

interface FraudCheckHistoryRepository: JpaRepository<FraudCheckHistory, Long>