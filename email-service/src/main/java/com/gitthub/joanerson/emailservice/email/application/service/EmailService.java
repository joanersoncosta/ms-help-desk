package com.gitthub.joanerson.emailservice.email.application.service;

import com.gitthub.joanerson.emailservice.ordem.domain.dto.OrdemCriadaResponse;

public interface EmailService {
	void enviaEmail(OrdemCriadaResponse response);
}
