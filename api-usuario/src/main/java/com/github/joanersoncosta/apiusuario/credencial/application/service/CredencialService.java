package com.github.joanersoncosta.apiusuario.credencial.application.service;

import com.github.joanersoncosta.apiusuario.credencial.domain.Credencial;
import com.github.joanersoncosta.apiusuario.credencial.domain.CredencialRequest;

public interface CredencialService {
	void criaNovaCredencial(CredencialRequest credencialRequest);
	Credencial buscaCredencialPorUsuario(String usuario);
}