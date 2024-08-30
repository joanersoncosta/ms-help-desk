package com.github.joanersoncosta.apiordem.ordem.application.service;

import com.github.joanersoncosta.apiordem.ordem.application.api.request.NovaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.application.api.response.NovaOrdemReIdsponse;

public interface OrdemService {
	NovaOrdemReIdsponse criaNovaOrdem(NovaOrdemRequest novaOrdemRequest);
}