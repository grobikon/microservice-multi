package ru.grobikon.notification.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.grobikon.notification.model.NotificationEntity

interface NotificationRepository: JpaRepository<NotificationEntity, Long>