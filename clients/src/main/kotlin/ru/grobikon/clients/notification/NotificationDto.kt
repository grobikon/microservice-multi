package ru.grobikon.clients.notification

data class NotificationDto(
    var message: String? = null,
    var toCustomerEmail: String? = null,
    var toCustomerId: Long? = null,
)