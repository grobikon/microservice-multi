package ru.grobikon.customer.service

import ru.grobikon.customer.dto.CustomerRegistrationDto

interface CustomerService {
    fun registerCustomer(customerRequest: CustomerRegistrationDto)
}