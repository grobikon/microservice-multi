package ru.grobikon.fraud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@SpringBootApplication
@EnableEurekaClient
@PropertySources(
    PropertySource("classpath:clients-\${spring.profiles.active}.properties")
)
class FraudApplication

fun main(args: Array<String>) {
    runApplication<FraudApplication>(*args)
}