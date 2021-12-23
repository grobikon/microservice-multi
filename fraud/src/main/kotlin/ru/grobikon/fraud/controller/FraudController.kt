package ru.grobikon.fraud.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.grobikon.fraud.dto.FraudCheckDto
import ru.grobikon.fraud.service.FraudCheckService

@RestController
@RequestMapping("api/v1fraud-check")
class FraudController(
    private val fraudCheckService: FraudCheckService
) {
    private val logger = LoggerFactory.getLogger(FraudController::class.java)

    @GetMapping("{customerId}")
    fun isFraudster(@PathVariable customerId: Int): FraudCheckDto {
        val isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId)
        logger.info("Запрос на проверку мошенничества клиента: $customerId")
        return FraudCheckDto(isFraudulentCustomer)
    }
}