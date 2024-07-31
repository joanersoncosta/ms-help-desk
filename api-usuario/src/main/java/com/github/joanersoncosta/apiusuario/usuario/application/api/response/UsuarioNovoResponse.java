package com.github.joanersoncosta.apiusuario.usuario.application.api.response;

import java.util.UUID;

import com.github.joanersoncosta.apiusuario.usuario.domain.Usuario;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UsuarioNovoResponse {
	private final UUID idUsuario;
	
	public UsuarioNovoResponse(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
	}
}
