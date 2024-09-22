package com.github.joanersoncosta.apiordem.ordem.domain.dtos;

import com.github.joanersoncosta.apiordem.ordem.application.api.response.OrdemResponse;
import com.github.joanersoncosta.apiordem.usuario.infra.feign.client.UsuarioResponse;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrdemCriadaResponse{
	private OrdemResponse ordemResponse;
	private UsuarioResponse tecnicoResponse;
	private UsuarioResponse clienteResponse;

	public OrdemCriadaResponse(OrdemResponse ordemResponse, UsuarioResponse tecnicoResponse,
			UsuarioResponse clienteResponse) {
		this.ordemResponse = ordemResponse;
		this.tecnicoResponse = tecnicoResponse;
		this.clienteResponse = clienteResponse;
	}

}