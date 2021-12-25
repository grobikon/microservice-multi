package ru.grobikon.notification.service

import ru.grobikon.clients.notification.NotificationDto

interface NotificationService {
    fun send(notificationDto: NotificationDto)
}