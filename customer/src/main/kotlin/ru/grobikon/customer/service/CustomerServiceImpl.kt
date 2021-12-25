package ru.grobikon.customer.service

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.grobikon.clients.fraud.FraudCheckDto
import ru.grobikon.clients.fraud.FraudClient
import ru.grobikon.customer.dto.CustomerDto
import ru.grobikon.customer.model.CustomerEntity
import ru.grobikon.customer.repository.CustomerRepository


@Service
class CustomerServiceImpl(
    private val customerRepository: CustomerRepository,
    private val restTemplate: RestTemplate,
    private val fraudClient: FraudClient
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
            val fraudCheckDto = fraudClient.isFraudster(customer.id)
            if (fraudCheckDto is FraudCheckDto && fraudCheckDto.isFraudster) {
                throw IllegalStateException("fraudster")
            }
        }catch (e: Exception) {
            println(e.message)
            throw IllegalStateException(e.message)
        }

        //todo: отправить уведомление
    }
}