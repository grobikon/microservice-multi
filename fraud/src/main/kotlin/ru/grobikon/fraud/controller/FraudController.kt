package ru.grobikon.fraud.controller

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

    @GetMapping("{customerId}")
    fun isFraudster(@PathVariable customerId: Int): FraudCheckDto {
        val isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId)
        return FraudCheckDto(isFraudulentCustomer)
    }
}