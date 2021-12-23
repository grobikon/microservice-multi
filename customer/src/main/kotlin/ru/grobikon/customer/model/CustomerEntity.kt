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
    var id: Long = 0,
    var firstName: String,
    var lastName: String,
    var email: String
)