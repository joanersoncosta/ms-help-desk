package com.github.joanersoncosta.apisecurity.credencial.domain;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Credencial {
	private UUID idCredencial;
	private String usuario;
	private String senha;
	private Perfil perfil;
	private boolean validado;
}