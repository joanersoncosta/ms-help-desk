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
		credencialRepository.salva(new Credencial(credencialRequest.usuarioRequest().email(), credencialRequest.usuarioRequest().senha(), credencialRequest.usuarioRequest().perfil()));
		log.debug("[finaliza] CrendencialService - criaNovaCredencial");
	}
	
	@Override
	public Credencial buscaCredencialPorUsuario(String usuario) {
		log.info("[inicia] CredencialSpringDataJpaService - buscaCredencialPorUsuario");
		Credencial credencial = credencialRepository.buscaCredencialPorUsuario(usuario);
		log.info("[finaliza] CredencialSpringDataJpaService - buscaCredencialPorUsuario");
		return credencial;
	}	
}