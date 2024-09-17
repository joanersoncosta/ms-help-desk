package com.github.joanersoncosta.apiordem.ordem.application.repository;

import java.util.List;
import java.util.UUID;

import com.github.joanersoncosta.apiordem.ordem.domain.Ordem;

public interface OrdemRepository {
	Ordem salva(Ordem ordem);
	Ordem buscaOrdemPorId(UUID idOrdem);
	void deletaOrdem(Ordem ordem);
	List<Ordem> buscaOrdens();
}