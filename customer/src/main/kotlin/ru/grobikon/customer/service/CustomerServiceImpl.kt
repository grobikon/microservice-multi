package ru.grobikon.customer.service

import org.springframework.http.ResponseEntity
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
        try {

            val responseEntity: ResponseEntity<Any> = restTemplate.getForEntity(
                "http://FRAUD/api/v1/fraud-check/${customer.id}",
                Any::class.java
            )
            if (responseEntity.body != null
                && responseEntity.body is FraudCheckDto
                && (responseEntity.body!! as FraudCheckDto).isFraudster) {
                throw IllegalStateException("fraudster")
            }
        }catch (e: Exception) {
            println(e.message)
            throw IllegalStateException(e.message)
        }

        //todo: отправить уведомление
    }
}