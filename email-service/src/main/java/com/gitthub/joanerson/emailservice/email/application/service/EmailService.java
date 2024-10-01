package com.gitthub.joanerson.emailservice.email.application.service;

import com.gitthub.joanerson.emailservice.email.domain.enuns.OperationEnum;
import com.gitthub.joanerson.emailservice.ordem.domain.dto.OrdemCriadaResponse;

import jakarta.mail.MessagingException;

public interface EmailService {
	void enviaEmail(OrdemCriadaResponse response, OperationEnum operation) throws MessagingException;
}
