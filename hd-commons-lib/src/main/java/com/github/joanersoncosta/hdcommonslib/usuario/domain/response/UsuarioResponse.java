package com.github.joanersoncosta.hdcommonslib.usuario.domain.response;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import com.github.joanersoncosta.hdcommonslib.usuario.enuns.PerfilUsuario;

public record UsuarioResponse(
	UUID idUsuario,
	String nome,
	String email,
	Set<PerfilUsuario> perfil
	) implements Serializable{
	private static final long serialVersionUID = 1L;
}