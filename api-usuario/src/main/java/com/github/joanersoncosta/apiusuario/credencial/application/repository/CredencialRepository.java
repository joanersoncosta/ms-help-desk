package com.github.joanersoncosta.apiusuario.credencial.application.repository;

import com.github.joanersoncosta.apiusuario.credencial.domain.Credencial;

public interface CredencialRepository {
	Credencial salva(Credencial credencial);
	Credencial buscaCredencialPorUsuario(String usuario);
}
