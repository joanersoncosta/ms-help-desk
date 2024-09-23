package com.gitthub.joanerson.emailservice.ordem.infra;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.gitthub.joanerson.emailservice.email.application.service.EmailService;
import com.gitthub.joanerson.emailservice.email.domain.enuns.OperationEnum;
import com.gitthub.joanerson.emailservice.handler.APIException;
import com.gitthub.joanerson.emailservice.ordem.domain.dto.OrdemCriadaResponse;

import jakarta.mail.MessagingException;
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
		log.debug("[Ordem de serviço recebida] {}", ordemResponse);
		try {
			emailService.enviaEmail(ordemResponse, OperationEnum.ORDEM_CRIADA);
		} catch (MessagingException ex) {
			log.error("Erro ao enviar email para ordem criada.");
			throw APIException.build(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao enviar email para o cliente.", ex);
		}
		log.debug("[finish] OrdemListener - ordemListenerCreate");
	}
}