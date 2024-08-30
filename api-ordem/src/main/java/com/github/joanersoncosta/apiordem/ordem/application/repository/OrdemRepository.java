package com.github.joanersoncosta.apiordem.ordem.application.repository;

import com.github.joanersoncosta.apiordem.ordem.domain.Ordem;

public interface OrdemRepository {
	Ordem salva(Ordem ordem);
}