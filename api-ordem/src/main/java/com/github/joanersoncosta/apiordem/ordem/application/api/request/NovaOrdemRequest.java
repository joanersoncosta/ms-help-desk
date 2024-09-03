package com.github.joanersoncosta.apiordem.ordem.application.api.request;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NovaOrdemRequest(
		@Schema(description = "Request ID", example = "123e4567-e89b-12d3-a456-426614174000")
		@NotNull(message = "requestId não pode ser nulo ou em branco.")
		UUID idRequest,
		@Schema(description = "Cliente ID", example = "")
		@NotNull(message = "idCliente não pode ser nulo ou em branco.")
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