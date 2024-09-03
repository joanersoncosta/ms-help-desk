package com.github.joanersoncosta.apiordem.ordem.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.apiordem.handler.APIException;
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
		try {
		ordemSpringJpaInfraRepository.save(ordem);
		}catch (Exception e) {
			APIException.build(HttpStatus.BAD_REQUEST, "Erro ao salvar Ordem.", e);
		}
		log.debug("[finish] OrdemInfraRepository - salva");
		return ordem;
	}

	@Override
	public Ordem buscaOrdemPorId(UUID idOrdem) {
		log.debug("[start] OrdemInfraRepository - buscaOrdemPorId");
		Ordem ordem = ordemSpringJpaInfraRepository.findById(idOrdem)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Ordem não encontrada."));
		log.debug("[finish] OrdemInfraRepository - buscaOrdemPorId");
		return ordem;
	}

	@Override
	public void deletaOrdem(Ordem ordem) {
		log.debug("[start] OrdemInfraRepository - deletaOrdem");
		ordemSpringJpaInfraRepository.delete(ordem);
		log.debug("[finish] OrdemInfraRepository - deletaOrdem");
	}

	@Override
	public List<Ordem> buscaOrdens() {
		log.debug("[start] OrdemInfraRepository - buscaOrdens");
		List<Ordem> ordens = ordemSpringJpaInfraRepository.findAll();
		log.debug("[finish] OrdemInfraRepository - buscaOrdens");
		return ordens;
	}

}