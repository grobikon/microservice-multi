package ru.grobikon.notification.rabbitmq

import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import ru.grobikon.clients.notification.NotificationDto
import ru.grobikon.notification.service.NotificationService

@Component
class NotificationConsumer(
    private val notificationService: NotificationService
) {

    private val logger = LoggerFactory.getLogger(NotificationConsumer::class.java)

    /**
     * Потребитель сообщений из очереди RabbitMQ
     */
    @RabbitListener(queues = ["\${rabbitmq.queues.notification}"])
    fun consumer(notificationDto: NotificationDto) {
        logger.info("Получили $notificationDto сообщение из очереди")
        notificationService.send(notificationDto)
    }
}