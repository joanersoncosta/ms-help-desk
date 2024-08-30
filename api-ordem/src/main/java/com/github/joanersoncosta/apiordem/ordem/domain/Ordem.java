package com.github.joanersoncosta.apiordem.ordem.domain;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.apiordem.ordem.application.api.request.NovaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.domain.enuns.OrdemStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@Getter
@EqualsAndHashCode(of = "idOrdem")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Ordem implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idOrdem;
	@Column(nullable = false, length = 45)
	private UUID requestId;
	private UUID idCliente;
	@Column(nullable = false, length = 50)
	private String titlo;
	@Column(nullable = false, length = 1000)
	private String desccricao;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private OrdemStatus ordemStatus;
	private LocalDateTime dataCriacao;
	private LocalDateTime datafechamento;
	
	public Ordem(NovaOrdemRequest novaOrdemRequest) {
		this.requestId = novaOrdemRequest.requestId();
		this.idCliente = novaOrdemRequest.idCliente();
		this.titlo = novaOrdemRequest.titlo();
		this.desccricao = novaOrdemRequest.descricao();
		this.ordemStatus = OrdemStatus.ABERTO;
		this.dataCriacao = LocalDateTime.now();
	}
	
}