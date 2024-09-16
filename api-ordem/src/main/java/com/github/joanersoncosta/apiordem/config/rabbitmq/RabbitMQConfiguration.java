package com.github.joanersoncosta.apiordem.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfiguration {
	private final RabbitMQProperties rabbitMQProperties;

    @Bean
    public TopicExchange ordemExchange() {
        return new TopicExchange(rabbitMQProperties.getExchangeName());
    }

    @Bean
    public Queue ordemQueue() {
        return new Queue(rabbitMQProperties.getQueueName());
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(ordemQueue()).to(ordemExchange()).with(rabbitMQProperties.getRoutingKeyOrdemCreate());
    }
	
	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

}