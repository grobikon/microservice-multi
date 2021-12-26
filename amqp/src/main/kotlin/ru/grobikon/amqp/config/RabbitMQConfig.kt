package ru.grobikon.amqp.config

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig(
    private val connectionFactory: ConnectionFactory
) {

    //Producer позволяет нам отправлять сообщения
    @Bean
    fun amqpTemplate(): AmqpTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = jacksonConverter()
        return rabbitTemplate
    }

    //Получаем сообщения из очереди
    @Bean
    fun simpleRabbitListenerContainerFactory(): SimpleRabbitListenerContainerFactory {
        val factory = SimpleRabbitListenerContainerFactory()
        factory.setConnectionFactory(connectionFactory)
        factory.setMessageConverter(jacksonConverter())
        return factory
    }

    //Передавать сообщения, будем в виде Json
    @Bean
    fun jacksonConverter(): MessageConverter {
        return Jackson2JsonMessageConverter()
    }
    
}