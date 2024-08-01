package com.github.joanersoncosta.apisecurity.credencial.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apisecurity.credencial.application.repository.CredencialRepository;
import com.github.joanersoncosta.apisecurity.credencial.domain.Credencial;
import com.github.joanersoncosta.apisecurity.credencial.domain.CredencialDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrendencialApplicationService implements CredencialService {
	private final CredencialRepository credencialRepository;

	@Override
	public CredencialDetails buscaCredencialPorUsuario(String usuario) {
		log.info("[inicia] CredencialSpringDataJpaService - buscaCredencialPorUsuario");
		Credencial credencial = credencialRepository.buscaCredencialPorUsuario(usuario);
		log.info("[finaliza] CredencialSpringDataJpaService - buscaCredencialPorUsuario");
		return new CredencialDetails(credencial);
	}	
}