package com.github.joanersoncosta.apiordem.ordem.domain.enuns;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.github.joanersoncosta.apiordem.handler.APIException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum OrdemStatus {
	ABERTO("Aberto"),
	EM_PROGRESSO("Em progresso"),
	FECHADO("Fechado"),
	CANCELADO("Cancelado");
	
	@Getter
	private final String descricao;
	
	public static OrdemStatus toEnum(String desccricao) {
		return Arrays.stream(OrdemStatus.values())
				.filter(ordemStatus -> ordemStatus.getDescricao().equals(desccricao))
				.findFirst()
				.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Descrição inválida: " + desccricao));
	}
}