package com.github.joanersoncosta.apiusuario.credencial.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiusuario.credencial.application.repository.CredencialRepository;
import com.github.joanersoncosta.apiusuario.credencial.domain.Credencial;
import com.github.joanersoncosta.apiusuario.credencial.domain.CredencialRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrendencialApplicationService implements CredencialService {
	private final CredencialRepository credencialRepository;

	@Override
	public void criaNovaCredencial(CredencialRequest credencialRequest) {
		log.debug("[inicia] CrendencialService - criaNovaCredencial");
		credencialRepository.salva(new Credencial(credencialRequest.usuario(), credencialRequest.senha(), credencialRequest.perfil()));
		log.debug("[finaliza] CrendencialService - criaNovaCredencial");
	}

}