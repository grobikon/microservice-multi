package ru.grobikon.customer.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.grobikon.customer.model.CustomerEntity

interface CustomerRepository: JpaRepository<CustomerEntity, Long>