package ru.grobikon.notification.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class NotificationConfig{

    @Value("\${rabbitmq.exchanges.internal}")
    lateinit var internalExchange: String
    @Value("\${rabbitmq.queues.notification}")
    lateinit var notificationQueue: String
    @Value("\${rabbitmq.routing-keys.internal-notification}")
    lateinit var internalNotificationRoutingKey: String

    /**
     * Обменник
     */
    @Bean
    fun internalTopicExchange(): TopicExchange = TopicExchange(internalExchange)

    /**
     * Очередь
     */
    @Bean
    fun notificationQueue(): Queue = Queue(notificationQueue)

    /**
     * Связываем обменник и очередь
     */
    @Bean
    fun internalToNotificationBinding(): Binding =
        BindingBuilder
            .bind(notificationQueue())
            .to(internalTopicExchange())
            .with(internalNotificationRoutingKey)
}