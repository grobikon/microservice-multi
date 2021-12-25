package ru.grobikon.fraud.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class FraudCheckHistory(
    @Id
    @SequenceGenerator(
        name = "fraud_id_sequence",
        sequenceName = "fraud_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "fraud_id_sequence")
    val id: Long = 0,
    val customerId: Long,
    val isFraudster: Boolean,
    val date: LocalDateTime
)