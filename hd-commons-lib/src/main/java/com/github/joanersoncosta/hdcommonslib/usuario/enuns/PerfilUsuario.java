package com.github.joanersoncosta.hdcommonslib.usuario.enuns;

import java.util.Arrays;

public enum PerfilUsuario {
	ADMIN("ROLE_ADMIN"), COMUM("ROLE_COMUM"), TECNICO("ROLE_TECNICO");

	private final String descricao;

	PerfilUsuario(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static PerfilUsuario toEnum(final String descricao) {
		return Arrays.stream(PerfilUsuario.values())
				.filter(perfilUsuario -> perfilUsuario.getDescricao().equals(descricao))
				.findFirst()
				.orElseThrow(null);
	}
}