package ru.grobikon.notification.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import ru.grobikon.clients.fraud.FraudCheckDto
import ru.grobikon.clients.notification.NotificationDto
import ru.grobikon.notification.service.NotificationService

@RestController
@RequestMapping("api/v1/notification")
class NotificationController(
    private val notificationService: NotificationService
) {
    private val logger = LoggerFactory.getLogger(NotificationController::class.java)

    @PostMapping
    fun isFraudster(@RequestBody notificationDto: NotificationDto) {
        logger.info("Новое уведомление: $notificationDto")
        notificationService.send(notificationDto)
    }
}