package ru.grobikon.fraud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FraudApplication

fun main(args: Array<String>) {
    runApplication<FraudApplication>(*args)
}