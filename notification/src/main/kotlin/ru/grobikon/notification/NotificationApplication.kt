package ru.grobikon.notification

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableEurekaClient
class NotificationApplication

fun main(args: Array<String>) {
    runApplication<NotificationApplication>(*args)
}