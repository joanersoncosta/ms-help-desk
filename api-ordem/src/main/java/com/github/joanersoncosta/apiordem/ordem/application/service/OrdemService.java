package com.github.joanersoncosta.apiordem.ordem.application.service;

import java.util.UUID;

import com.github.joanersoncosta.apiordem.ordem.application.api.request.AtualizaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.application.api.request.NovaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.application.api.response.NovaOrdemReIdsponse;

public interface OrdemService {
	NovaOrdemReIdsponse criaNovaOrdem(NovaOrdemRequest novaOrdemRequest);
	void atalizaOrdem(UUID idOrdem, AtualizaOrdemRequest ordemRequest);
}