package com.gitthub.joanerson.emailservice.config.rabbbitmq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Configuration
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RabbitMQProperties {
	@Value("${rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("${rabbitmq.queue.name}")
    private String queueName;
    @Value("${rabbitmq.routingKey.name}")
    private String routingKeyOrdemCreate;
}