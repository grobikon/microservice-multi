package ru.grobikon.customer.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.grobikon.customer.dto.CustomerDto
import ru.grobikon.customer.service.CustomerService

@RestController
@RequestMapping("api/v1/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping
    fun registerCustomer(@RequestBody customerRequest: CustomerDto) {
        logger.info("Регистрация нового клиента: ${customerRequest.firstName}")
        customerService.registerCustomer(customerRequest)
    }
}