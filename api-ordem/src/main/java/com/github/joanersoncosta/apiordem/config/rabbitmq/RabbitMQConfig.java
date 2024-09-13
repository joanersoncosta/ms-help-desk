package com.github.joanersoncosta.apiordem.config.rabbitmq;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.BindingBuilder.TopicExchangeRoutingKeyConfigurer;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {
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
	public TopicExchangeRoutingKeyConfigurer binding() {
		return BindingBuilder.bind(ordemQueue()).to(ordemExchange());
	}
	
	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter);
		return rabbitTemplate;
	}

}