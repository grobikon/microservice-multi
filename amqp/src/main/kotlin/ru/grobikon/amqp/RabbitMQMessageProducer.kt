package ru.grobikon.amqp

import org.slf4j.LoggerFactory
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.stereotype.Component

/**
 * Создатель сообщений
 */
@Component
class RabbitMQMessageProducer(
    private val amqpTemplate: AmqpTemplate
) {
    private val logger = LoggerFactory.getLogger(RabbitMQMessageProducer::class.java)

    /**
     * @param payload - полезная нагрузка
     */
    fun publish(payload: Any, exchange: String, routingKey: String) {
        logger.info("Отправка $exchange с использованием ключа маршрутизации $routingKey. Полезная нагрузка $payload")
        amqpTemplate.convertAndSend(exchange, routingKey, payload)
        logger.info("Отправлено $exchange с использованием ключа маршрутизации $routingKey. Полезная нагрузка $payload")
    }
}