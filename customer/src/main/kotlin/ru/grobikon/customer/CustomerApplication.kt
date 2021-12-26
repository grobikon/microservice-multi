package ru.grobikon.customer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication(
    scanBasePackages = [
        "ru.grobikon.customer",
        "ru.grobikon.amqp"
    ]
)
@EnableEurekaClient
@EnableFeignClients(basePackages = ["ru.grobikon.clients"])
class CustomerApplication

fun main(args: Array<String>) {
    runApplication<CustomerApplication>(*args)
}