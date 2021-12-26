package ru.grobikon.notification.service

import org.springframework.stereotype.Service
import ru.grobikon.clients.notification.NotificationDto
import ru.grobikon.notification.model.NotificationEntity
import ru.grobikon.notification.repository.NotificationRepository
import java.time.LocalDateTime

@Service
class NotificationServiceImpl(
    private val notificationRepository: NotificationRepository
): NotificationService {

    override fun send(notificationDto: NotificationDto) {
        val notificationEntity = NotificationEntity(
            date = LocalDateTime.now(),
            message = notificationDto.message!!,
            sender = "Grobikon Notification Service",
            toCustomerId = notificationDto.toCustomerId!!,
            toCustomerEmail = notificationDto.toCustomerEmail!!
        )
        notificationRepository.save(notificationEntity)
    }
}