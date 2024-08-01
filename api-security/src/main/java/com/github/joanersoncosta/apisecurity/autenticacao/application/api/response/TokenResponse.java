package com.github.joanersoncosta.apisecurity.autenticacao.application.api.response;

import com.github.joanersoncosta.apisecurity.autenticacao.domain.Token;

import lombok.Value;

@Value
public class TokenResponse {
	private String token;
	private String tipo;

	public TokenResponse(Token token) {
		this.token = token.getToken();
		this.tipo = token.getTipo();
	}
}