package ru.grobikon.fraud.service

import org.springframework.stereotype.Service
import ru.grobikon.fraud.model.FraudCheckHistory
import ru.grobikon.fraud.repository.FraudCheckHistoryRepository
import java.time.LocalDateTime

@Service
class FraudCheckServiceImpl(
    private val fraudCheckHistoryRepository: FraudCheckHistoryRepository
): FraudCheckService {
    override fun isFraudulentCustomer(customerId: Long): Boolean {
        val fraudCheckHistory = FraudCheckHistory(
            customerId = customerId,
            isFraudster = false,
            date = LocalDateTime.now()
        )
        fraudCheckHistoryRepository.save(fraudCheckHistory)
        return false
    }
}