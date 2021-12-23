package ru.grobikon.customer.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class CustomerConfig {

    @Bean
    fun restTemplate(): RestTemplate = RestTemplate()
}