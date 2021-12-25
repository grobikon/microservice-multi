package ru.grobikon.notification.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class NotificationEntity(
    @Id
    @SequenceGenerator(
        name = "notification_id_sequence",
        sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "notification_id_sequence")
    val notificationId: Long = 0,
    val date: LocalDateTime,
    val message: String,
    val sender: String,
    val toCustomerId: Long,
    val toCustomerEmail: String,
)