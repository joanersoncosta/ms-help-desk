package com.github.joanersoncosta.apiordem.ordem.application.repository;

import java.util.UUID;

import com.github.joanersoncosta.apiordem.ordem.domain.Ordem;

public interface OrdemRepository {
	Ordem salva(Ordem ordem);
	Ordem buscaOrdemPorId(UUID idOrdem);
	void deletaOrdem(Ordem ordem);
}