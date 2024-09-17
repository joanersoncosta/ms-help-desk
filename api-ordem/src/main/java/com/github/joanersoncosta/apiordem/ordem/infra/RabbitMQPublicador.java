package com.github.joanersoncosta.apiordem.ordem.infra;

import com.github.joanersoncosta.apiordem.ordem.domain.dtos.OrdemCriadaResponse;

public interface RabbitMQPublicador {
	void publica(OrdemCriadaResponse ordem);
}