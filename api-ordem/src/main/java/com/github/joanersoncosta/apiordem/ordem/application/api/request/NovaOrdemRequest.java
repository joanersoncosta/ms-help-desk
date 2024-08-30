package com.github.joanersoncosta.apiordem.ordem.application.api.request;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NovaOrdemRequest(
		@Schema(description = "Request ID", example = "")
		@NotBlank(message = "requestId não pode ser nulo ou em branco.")
		@Size(min = 24, max = 36, message = "requestId pode ter entre 24 e 36 characters.")
		UUID requestId,
		@Schema(description = "Cliente ID", example = "")
		@NotBlank(message = "idCliente não pode ser nulo ou em branco.")
		@Size(min = 24, max = 36, message = "idCliente pode ter entre 24 e 36 characters.")
		UUID idCliente,
		@Schema(description = "Titlo da ordem", example = "")
		@NotBlank(message = "Titlo não pode ser nulo ou em branco.")
		@Size(min = 3, max = 50, message = "idCliente pode ter entre 3 e 50 characters.")
		String titlo,
		@Schema(description = "Descricao da ordem", example = "")
		@NotBlank(message = "descricao não pode ser nulo ou em branco.")
		@Size(min = 3, max = 1000, message = "idCliente pode ter entre 3 e 1000 characters.")
		String descricao
		) {
}