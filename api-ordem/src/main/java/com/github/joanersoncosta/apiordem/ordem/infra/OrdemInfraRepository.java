package com.github.joanersoncosta.apiordem.ordem.infra;

import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.apiordem.ordem.application.repository.OrdemRepository;
import com.github.joanersoncosta.apiordem.ordem.domain.Ordem;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class OrdemInfraRepository implements OrdemRepository{
	private final OrdemSpringJpaInfraRepository ordemSpringJpaInfraRepository;
	
	@Override
	public Ordem salva(Ordem ordem) {
		log.debug("[start] OrdemInfraRepository - salva");
		Ordem ordemCriada = ordemSpringJpaInfraRepository.save(ordem);
		log.debug("[finish] OrdemInfraRepository - salva");
		return ordemCriada;
	}

}