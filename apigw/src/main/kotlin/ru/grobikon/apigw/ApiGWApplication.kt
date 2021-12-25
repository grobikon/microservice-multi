package ru.grobikon.apigw

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class ApiGWApplication

fun main(args: Array<String>){
    runApplication<ApiGWApplication>(*args)
}