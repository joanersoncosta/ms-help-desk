package com.github.joanersoncosta.hdcommonslib.usuario.enuns;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.github.joanersoncosta.hdcommonslib.handler.APIException;

public enum PerfilUsuario {
	ADMIN("ROLE_ADMIN"), COMUM("ROLE_COMUM"), TECNICO("ROLE_TECNICO");

	private final String descricao;

	PerfilUsuario(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static PerfilUsuario retornaPerfilUsuario(final String descricao) {
		return Arrays.stream(PerfilUsuario.values())
				.filter(perfilUsuario -> perfilUsuario.getDescricao().equals(descricao))
				.findFirst()
				.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Descrição invalida!"));
	}
}