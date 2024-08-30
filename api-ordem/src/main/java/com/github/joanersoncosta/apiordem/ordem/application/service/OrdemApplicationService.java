package com.github.joanersoncosta.apiordem.ordem.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiordem.ordem.application.api.request.NovaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.application.api.response.NovaOrdemReIdsponse;
import com.github.joanersoncosta.apiordem.ordem.application.repository.OrdemRepository;
import com.github.joanersoncosta.apiordem.ordem.application.service.mapper.OrdemMapper;
import com.github.joanersoncosta.apiordem.ordem.domain.Ordem;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrdemApplicationService implements OrdemService {
	private final OrdemRepository ordemRepository;
	private final OrdemMapper ordemMapper;
	
	@Override
	public NovaOrdemReIdsponse criaNovaOrdem(NovaOrdemRequest novaOrdemRequest) {
		log.debug("[start] OrdemApplicationService - criaNovaOrdem");
		log.debug("[novaOrdemRequest] {}", novaOrdemRequest.toString());
		Ordem ordem = ordemRepository.salva(new Ordem(novaOrdemRequest));
		log.debug("[finish] OrdemApplicationService - criaNovaOrdem");
		return ordemMapper.fromIdOrdemResponse(ordem);
	}

}