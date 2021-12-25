package ru.grobikon.fraud.service

interface FraudCheckService {
    fun isFraudulentCustomer(customerId: Long): Boolean
}