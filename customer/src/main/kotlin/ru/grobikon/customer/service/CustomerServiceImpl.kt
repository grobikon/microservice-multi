package ru.grobikon.customer.service

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.grobikon.customer.dto.CustomerDto
import ru.grobikon.customer.dto.FraudCheckDto
import ru.grobikon.customer.model.CustomerEntity
import ru.grobikon.customer.repository.CustomerRepository

@Service
class CustomerServiceImpl(
    private val customerRepository: CustomerRepository,
    private val restTemplate: RestTemplate
) : CustomerService {

    override fun registerCustomer(customerRequest: CustomerDto) {
        val customer = CustomerEntity(
            firstName = customerRequest.firstName,
            lastName = customerRequest.lastName,
            email = customerRequest.email)

        //todo: проверка email на валидность
        //todo: проверка принята почта или нет
        customerRepository.saveAndFlush(customer)
        //todo: проверка не мошенник
        val url = "http://localhost:8081/api/v1fraud-check/${customer.id}"
        val fraudCheckResponse = restTemplate.getForObject(url, FraudCheckDto::class.java)

        if (fraudCheckResponse != null && fraudCheckResponse.isFraudster) {
            throw IllegalStateException("fraudster")
        }
        //todo: отправить уведомление
    }
}