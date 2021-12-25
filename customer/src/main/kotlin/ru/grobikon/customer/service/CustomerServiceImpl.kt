package ru.grobikon.customer.service

import org.springframework.stereotype.Service
import ru.grobikon.clients.fraud.FraudCheckDto
import ru.grobikon.clients.fraud.FraudClient
import ru.grobikon.clients.notification.NotificationClient
import ru.grobikon.clients.notification.NotificationDto
import ru.grobikon.customer.dto.CustomerDto
import ru.grobikon.customer.model.CustomerEntity
import ru.grobikon.customer.repository.CustomerRepository


@Service
class CustomerServiceImpl(
    private val customerRepository: CustomerRepository,
    private val fraudClient: FraudClient,
    private val notificationClient: NotificationClient
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
            val fraudCheckDto = fraudClient.isFraudster(customer.customerId)
            if (fraudCheckDto is FraudCheckDto && fraudCheckDto.isFraudster) {
                throw IllegalStateException("fraudster")
            }
        }catch (e: Exception) {
            println(e.message)
            throw IllegalStateException(e.message)
        }

        //todo: make it async. i.e add to queue
        val notificationDto = NotificationDto(
            toCustomerId = customer.customerId,
            toCustomerEmail = customer.email,
            message = "Привет ${customer.firstName}, приветствуем в Grobikon service."
        )
        notificationClient.sendNotification(notificationDto)
    }
}