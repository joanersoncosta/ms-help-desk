package com.github.joanersoncosta.apiordem.ordem.application.api.response;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.apiordem.ordem.domain.enuns.OrdemStatus;

public record OrdemResponse(
	UUID idOrdem,
	UUID idRequest,
	UUID idCliente,
	String titlo,
	String descricao,
	OrdemStatus ordemStatus,
	LocalDateTime dataCriacao,
	LocalDateTime dataFechamento) implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;
}