package ru.grobikon.customer.rest

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.grobikon.customer.dto.CustomerRegistrationDto
import ru.grobikon.customer.service.CustomerService

@RestController
@RequestMapping("api/v1/controllers")
class CustomerController(
    private val customerService: CustomerService
) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @PostMapping
    fun registerCustomer(@RequestBody customerRequest: CustomerRegistrationDto) {
        log.info("Регистрация нового клиента: ${customerRequest.firstName}")
        customerService.registerCustomer(customerRequest)
    }
}