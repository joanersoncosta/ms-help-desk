package com.github.joanersoncosta.apiordem.ordem.application.api.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.apiordem.ordem.domain.enuns.OrdemStatus;

public record OrdemResponse(
	    UUID idOrdem,
		UUID requestId,
		UUID idCliente,
		String titlo,
		String desccricao,
		OrdemStatus ordemStatus,
		LocalDateTime dataCriacao,
		LocalDateTime datafechamento) {
}