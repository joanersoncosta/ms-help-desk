package com.github.joanersoncosta.apiordem.ordem.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.github.joanersoncosta.apiordem.ordem.application.api.request.AtualizaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.application.api.request.NovaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.application.api.response.NovaOrdemReIdsponse;
import com.github.joanersoncosta.apiordem.ordem.application.api.response.OrdemResponse;
import com.github.joanersoncosta.apiordem.ordem.application.service.OrdemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class OrdemRestController implements OrdemAPI {
	private final OrdemService ordemService;
	
	@Override
	public NovaOrdemReIdsponse criaNovaOrdem(NovaOrdemRequest novaOrdemRequest) {
		log.debug("[start] OrdemRestController - criaNovaOrdem");
		NovaOrdemReIdsponse novaOrdemReIdsponse = ordemService.criaNovaOrdem(novaOrdemRequest);
		log.debug("[finish] OrdemRestController - criaNovaOrdem");
		return novaOrdemReIdsponse;
	}

	@Override
	public void atalizaOrdem(UUID idOrdem, AtualizaOrdemRequest ordemRequest) {
		log.debug("[start] OrdemRestController - atalizaOrdem");
		ordemService.atalizaOrdem(idOrdem, ordemRequest);
		log.debug("[finish] OrdemRestController - atalizaOrdem");
	}

	@Override
	public OrdemResponse buscaOrdemPorId(UUID idOrdem) {
		log.debug("[start] OrdemRestController - buscaOrdemPorId");
		OrdemResponse ordemResponse = ordemService.buscaOrdemPorId(idOrdem);
		log.debug("[finish] OrdemRestController - buscaOrdemPorId");
		return ordemResponse;
	}

}