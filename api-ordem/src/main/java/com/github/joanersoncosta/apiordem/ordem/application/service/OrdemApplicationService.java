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
import com.github.joanersoncosta.apiordem.ordem.domain.dtos.OrdemCriadaResponse;
import com.github.joanersoncosta.apiordem.ordem.infra.RabbitMQPublicador;
import com.github.joanersoncosta.apiordem.usuario.infra.feign.UsuarioClientFeign;
import com.github.joanersoncosta.apiordem.usuario.infra.feign.client.UsuarioResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrdemApplicationService implements OrdemService {
	private final OrdemRepository ordemRepository;
	private final OrdemMapper ordemMapper;
	private final UsuarioClientFeign usuarioClientFeign;
	private final RabbitMQPublicador rabbitMQPublicador;

	@Override
	public NovaOrdemReIdsponse criaNovaOrdem(NovaOrdemRequest novaOrdemRequest) {
		log.debug("[start] OrdemApplicationService - criaNovaOrdem");
		log.debug("[novaOrdemRequest] {}", novaOrdemRequest.toString());
//		var cliente = new UsuarioResponse(UUID.fromString("b67b2c68-8b22-41df-a29b-3c49d79726dd"), "joao", "joao@gmail.com");//validaUsuarioId(novaOrdemRequest.idCliente());
//		var tecnico = new UsuarioResponse(UUID.fromString("6985c841-e2c3-4cdf-a275-8b8e754efcda"), "Alex", "alex@gmail.com");//validaUsuarioId(novaOrdemRequest.idRequest());
		var cliente = validaUsuarioId(novaOrdemRequest.idCliente());
		var tecnico = validaUsuarioId(novaOrdemRequest.idRequest());

		Ordem ordem = ordemRepository.salva(new Ordem(novaOrdemRequest));
		rabbitMQPublicador.publica(new OrdemCriadaResponse(ordemMapper.fromOrdemResponse(ordem), tecnico, cliente));
		log.debug("[finish] OrdemApplicationService - criaNovaOrdem");
		return ordemMapper.fromIdOrdemResponse(ordem);
	}

	@Override
	public void atualizaOrdem(UUID idOrdem, AtualizaOrdemRequest ordemRequest) {
		log.debug("[start] OrdemApplicationService - atualizaOrdem");
		log.debug("[ordemRequest] {}", ordemRequest.toString());
		Ordem ordem = ordemRepository.buscaOrdemPorId(idOrdem);
		ordem = ordemMapper.fromOrdemRequest(ordem, ordemRequest);
		ordemRepository.salva(ordem);
		log.debug("[finish] OrdemApplicationService - atualizaOrdem");
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
	
	public UsuarioResponse validaUsuarioId(UUID idUsuario) {
		log.debug("[start] OrdemApplicationService - validaUsuarioId");
		UsuarioResponse usuario = usuarioClientFeign.buscaUsuarioPorId(idUsuario);
		log.debug("[finish] OrdemApplicationService - validaUsuarioId");
		return usuario;
	}

}