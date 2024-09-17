package com.github.joanersoncosta.apiordem.ordem.domain.dtos;

import java.io.Serial;
import java.io.Serializable;

import com.github.joanersoncosta.apiordem.ordem.application.api.response.OrdemResponse;
import com.github.joanersoncosta.apiordem.usuario.infra.feign.client.UsuarioResponse;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class OrdemCriadaResponse implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;
	private OrdemResponse ordemResponse;
	private UsuarioResponse tecnicoResponse;
	private UsuarioResponse clienteResponse;
}