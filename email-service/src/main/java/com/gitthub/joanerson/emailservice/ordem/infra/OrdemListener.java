package com.gitthub.joanerson.emailservice.ordem.infra;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.gitthub.joanerson.emailservice.email.application.service.EmailService;
import com.gitthub.joanerson.emailservice.ordem.domain.dto.OrdemCriadaResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Component
public class OrdemListener {
	private final EmailService emailService;

	@RabbitListener(queues = "ordens.v1.ordem-criada")
	public void ordemListenerCreate(OrdemCriadaResponse ordemResponse) {
		log.debug("[start] OrdemListener - ordemListenerCreate");
		log.debug("[ordemResponse] {}", ordemResponse);
		emailService.enviaEmail(ordemResponse);
		log.debug("[finish] OrdemListener - ordemListenerCreate");
	}
}