package com.github.joanersoncosta.apiordem.ordem.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiordem.ordem.application.api.request.AtualizaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.application.api.request.NovaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.application.api.response.NovaOrdemReIdsponse;
import com.github.joanersoncosta.apiordem.ordem.application.api.response.OrdemResponse;
import com.github.joanersoncosta.apiordem.ordem.application.repository.OrdemRepository;
import com.github.joanersoncosta.apiordem.ordem.domain.Ordem;
import com.github.joanersoncosta.apiordem.ordem.domain.OrdemMapper;

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
		Ordem ordem = ordemRepository.salva(ordemMapper.fromOrdemRequest(novaOrdemRequest));
		log.debug("[finish] OrdemApplicationService - criaNovaOrdem");
		return ordemMapper.fromIdOrdemResponse(ordem);
	}

	@Override
	public void atalizaOrdem(UUID idOrdem, AtualizaOrdemRequest ordemRequest) {
		log.debug("[start] OrdemApplicationService - atalizaOrdem");
		log.debug("[ordemRequest] {}", ordemRequest.toString());
		Ordem ordem = ordemRepository.buscaOrdemPorId(idOrdem);
		ordem = ordemMapper.fromOrdemRequest(ordem, ordemRequest);
		ordemRepository.salva(ordem);
		log.debug("[finish] OrdemApplicationService - atalizaOrdem");
	}

	@Override
	public OrdemResponse buscaOrdemPorId(UUID idOrdem) {
		log.debug("[start] OrdemApplicationService - buscaOrdemPorId");
		log.debug("[idOrdem] {}", idOrdem);
		Ordem ordem = ordemRepository.buscaOrdemPorId(idOrdem);
		log.debug("[finish] OrdemApplicationService - buscaOrdemPorId");
		return ordemMapper.fromOrdemResponse(ordem);
	}

	@Override
	public void deletaOrdemPorId(UUID idOrdem) {
		log.debug("[start] OrdemApplicationService - deletaOrdemPorId");
		log.debug("[idOrdem] {}", idOrdem);
		Ordem ordem = ordemRepository.buscaOrdemPorId(idOrdem);
		ordemRepository.deletaOrdem(ordem);
		log.debug("[finish] OrdemApplicationService - deletaOrdemPorId");
	}

	@Override
	public List<OrdemResponse> listaOrdens() {
		log.debug("[start] OrdemApplicationService - listaOrdens");
		List<Ordem> ordens = ordemRepository.buscaOrdens();
		log.debug("[finish] OrdemApplicationService - listaOrdens");
		return ordemMapper.fromOrdemResponse(ordens);
	}

}