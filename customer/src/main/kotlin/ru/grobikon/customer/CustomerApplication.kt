package ru.grobikon.customer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources


@SpringBootApplication(
    scanBasePackages = [
        "ru.grobikon.customer",
        "ru.grobikon.amqp"
    ]
)
@EnableEurekaClient
@EnableFeignClients(basePackages = ["ru.grobikon.clients"])
@PropertySources(
    PropertySource("classpath:clients-\${spring.profiles.active}.properties")
)
class CustomerApplication

fun main(args: Array<String>) {
    runApplication<CustomerApplication>(*args)
}