package com.gitthub.joanerson.emailservice.email.application.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.gitthub.joanerson.emailservice.email.domain.enuns.OperationEnum;
import com.gitthub.joanerson.emailservice.email.domain.utils.EmailUtils;
import com.gitthub.joanerson.emailservice.ordem.domain.dto.OrdemCriadaResponse;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
@Service
public class EmailApplicationService implements EmailService {
	private final TemplateEngine templateEngine;
	private final JavaMailSender mailSender;

	@Override
	public void enviaEmail(OrdemCriadaResponse response, OperationEnum operation) throws MessagingException {
		log.debug("[start] EmailApplicationService - enviaEmail");

		MimeMessage message = mailSender.createMimeMessage();

		String process = getContext(response, operation);

		EmailUtils.getMimeMessage(message, process, response, operation.mensagem());

		mailSender.send(message);

		log.debug("[finish] EmailApplicationService - enviaEmail");
	}

	private String getContext(OrdemCriadaResponse response, OperationEnum operation) {
		log.debug("[start] EmailApplicationService - getContext");
		String tipoOperacao = getTipoOperacao(response, operation);
		log.debug("[finish] EmailApplicationService - getContext");
		return tipoOperacao;
	}

	private String getTipoOperacao(OrdemCriadaResponse response, OperationEnum operation) {
		log.debug("[start] EmailApplicationService - getContext");
		Context context = new Context();
		return switch (operation) {
		case ORDEM_CRIADA -> {
			log.info("Enviando email de criação de ordem de serviço");
			context = EmailUtils.getContextOrdemCriada(response);
			yield templateEngine.process("email/ordem-criada", context);
		}
		case ORDEM_ATUALIZADA -> {
			log.info("Enviando email de atualização de ordem de serviço");
//	                 context = EmailUtils.getContextOrdemAtualizada(response);
			yield templateEngine.process("email/order-updated", context);
		}
		case ORDEM_DELETADA -> {
			log.info("Enviando email de exclusão de ordem de serviço");
			// context = EmailUtils.getContextOrdemDeletada(response);
			yield templateEngine.process("email/order-deleted", context);
		}
		};
	}

}