package com.github.joanersoncosta.apisecurity.credencial.application.service;

import com.github.joanersoncosta.apisecurity.credencial.domain.CredencialDetails;

public interface CredencialService {
	CredencialDetails buscaCredencialPorUsuario(String usuario);
}