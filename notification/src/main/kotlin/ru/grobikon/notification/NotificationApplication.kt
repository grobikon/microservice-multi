package ru.grobikon.notification

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient


@SpringBootApplication(
    scanBasePackages = [
        "ru.grobikon.notification",
        "ru.grobikon.amqp"
    ]
)
@EnableEurekaClient
class NotificationApplication{

/*    @Bean
    fun commandLineRunner(producer: RabbitMQMessageProducer,
                          notificationConfig: NotificationConfig): CommandLineRunner {
        return CommandLineRunner {
            producer.publish(
                Person("Test", 18),
                notificationConfig.internalExchange,
                notificationConfig.internalNotificationRoutingKey
            )
        }
    }*/
}
//data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {
    runApplication<NotificationApplication>(*args)
}

