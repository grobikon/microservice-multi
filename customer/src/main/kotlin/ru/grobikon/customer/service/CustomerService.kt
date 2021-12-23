package ru.grobikon.customer.service

import ru.grobikon.customer.dto.CustomerDto

interface CustomerService {
    fun registerCustomer(customerRequest: CustomerDto)
}