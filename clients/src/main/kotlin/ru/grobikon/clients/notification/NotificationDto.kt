package ru.grobikon.clients.notification

data class NotificationDto(
    val message: String,
    val toCustomerEmail: String,
    val toCustomerId: Long,
)