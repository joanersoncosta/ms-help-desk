package com.github.joanersoncosta.apiordem.config.rabbitmq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Configuration
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RabbitMQProperties {
	@Value("${rabbit.exchange.name}")
	private String exchangeName;
	@Value("${rabbit.queue.name}")
	private String queueName;
	@Value("${rabbit.routingKey.name}")
	private String routingKeyOrdemCreate;
}