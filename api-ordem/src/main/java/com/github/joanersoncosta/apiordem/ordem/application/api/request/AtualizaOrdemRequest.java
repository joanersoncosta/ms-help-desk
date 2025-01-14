package com.github.joanersoncosta.apiordem.ordem.application.api.request;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

public record AtualizaOrdemRequest(
		@Schema(description = "Request ID", example = "")
		UUID requestId,
		@Schema(description = "Cliente ID", example = "")
		UUID idCliente,
		@Schema(description = "Titlo da ordem", example = "")
		@Size(min = 3, max = 50, message = "idCliente pode ter entre 3 e 50 characters.")
		String titlo,
		@Schema(description = "Descricao da ordem", example = "")
		@Size(min = 3, max = 1000, message = "idCliente pode ter entre 3 e 1000 characters.")
		String descricao
		) {
}