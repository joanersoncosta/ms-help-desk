package com.github.joanersoncosta.apiordem.ordem.application.service;

import java.util.List;
import java.util.UUID;

import com.github.joanersoncosta.apiordem.ordem.application.api.request.AtualizaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.application.api.request.NovaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.application.api.response.NovaOrdemReIdsponse;
import com.github.joanersoncosta.apiordem.ordem.application.api.response.OrdemResponse;

public interface OrdemService {
	NovaOrdemReIdsponse criaNovaOrdem(NovaOrdemRequest novaOrdemRequest);
	void atualizaOrdem(UUID idOrdem, AtualizaOrdemRequest ordemRequest);
	OrdemResponse buscaOrdemPorId(UUID idOrdem);
	void deletaOrdemPorId(UUID idOrdem);
	List<OrdemResponse> listaOrdens();
}