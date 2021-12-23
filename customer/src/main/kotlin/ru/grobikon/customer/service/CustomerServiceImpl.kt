package ru.grobikon.customer.service

import org.springframework.stereotype.Service
import ru.grobikon.customer.dto.CustomerRegistrationDto
import ru.grobikon.customer.model.CustomerEntity
import ru.grobikon.customer.repository.CustomerRepository

@Service
class CustomerServiceImpl(
    private val customerRepository: CustomerRepository
) : CustomerService {

    override fun registerCustomer(customerRequest: CustomerRegistrationDto) {
        val customer = CustomerEntity(
            firstName = customerRequest.firstName,
            lastName = customerRequest.lastName,
            email = customerRequest.email)

        //todo: проверка email на валидность
        //todo: проверка принята почта или нет
        customerRepository.save(customer)
    }
}