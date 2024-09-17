package com.github.joanersoncosta.apiordem.ordem.infra;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiordem.config.rabbitmq.RabbitMQProperties;
import com.github.joanersoncosta.apiordem.ordem.domain.dtos.OrdemCriadaResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class RabbitMQInfraPublicador implements RabbitMQPublicador {
	private final RabbitTemplate rabbitTemplate;
	private final RabbitMQProperties rabbitMQProperties;
    
	@Override
	public void publica(OrdemCriadaResponse ordemResponse) {
		log.debug("[start] RabbitMQInfraPublicador - publica");
		log.debug("[ordemResponse] {}", ordemResponse.toString());
		rabbitTemplate.convertAndSend(rabbitMQProperties.getExchangeName() , rabbitMQProperties.getRoutingKeyOrdemCreate(), ordemResponse);
		log.debug("[finish] RabbitMQInfraPublicador - publica");
	}

}