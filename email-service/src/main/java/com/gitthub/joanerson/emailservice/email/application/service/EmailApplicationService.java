package com.gitthub.joanerson.emailservice.email.application.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gitthub.joanerson.emailservice.ordem.domain.dto.OrdemCriadaResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
@Service
public class EmailApplicationService implements EmailService {
	@Value("${mail.text-created-order-confirmation}")
	private String textCreatedOrderConfirmation;
	private final SimpleMailMessage message;
	private final JavaMailSender mailSendder;
	
	@Override
	public void enviaEmail(OrdemCriadaResponse response) {
		log.debug("[start] EmailApplicationService - enviaEmail");
		SimpleMailMessage message = getSimpleMailMessage(response);	
		try {
			mailSendder.send(message);
		}catch (Exception e) {
		}
		log.debug("[finish] EmailApplicationService - enviaEmail");
	}

	private SimpleMailMessage getSimpleMailMessage(OrdemCriadaResponse response) {
		log.debug("[start] EmailApplicationService - getSimpleMailMessage");
		String subject = "Ordem criada com sucesso!";
		String text = String.format(textCreatedOrderConfirmation, 
				response.getClienteResponse().nome(),
				response.getOrdemResponse().idOrdem(),
				response.getOrdemResponse().titlo(),
				response.getOrdemResponse().descricao(),
				response.getOrdemResponse().dataCriacao(),
				response.getOrdemResponse().ordemStatus(),
				response.getTecnicoResponse().nome());
		
		SimpleMailMessage publicaEmail = publicaEmail(response, subject, text);
		log.debug("[finish] EmailApplicationService - getSimpleMailMessage");
		return publicaEmail;
	}

	private SimpleMailMessage publicaEmail(OrdemCriadaResponse response, String subject, String text) {
		log.debug("[start] EmailApplicationService - publicaEmail");
		message.setSubject(subject);
		message.setTo(response.getClienteResponse().email());
		message.setText(text);
		log.debug("[finish] EmailApplicationService - publicaEmail");
		return message;
	}

}