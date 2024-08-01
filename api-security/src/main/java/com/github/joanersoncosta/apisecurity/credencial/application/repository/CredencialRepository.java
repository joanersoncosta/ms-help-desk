package com.github.joanersoncosta.apisecurity.credencial.application.repository;

import com.github.joanersoncosta.apisecurity.credencial.domain.Credencial;

public interface CredencialRepository {
	Credencial buscaCredencialPorUsuario(String usuario);
}