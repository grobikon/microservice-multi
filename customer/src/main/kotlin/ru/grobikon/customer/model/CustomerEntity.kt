package ru.grobikon.customer.model

import javax.persistence.*

@Entity
class CustomerEntity(
    @Id
    @SequenceGenerator(
        name = "customer_id_sequence",
        sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "customer_id_sequence")
    val id: Long = 0,
    val firstName: String,
    val lastName: String,
    val email: String
)