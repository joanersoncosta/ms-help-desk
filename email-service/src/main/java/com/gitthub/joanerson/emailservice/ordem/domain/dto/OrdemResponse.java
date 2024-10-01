package com.gitthub.joanerson.emailservice.ordem.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.gitthub.joanerson.emailservice.ordem.domain.enuns.OrdemStatus;

public record OrdemResponse(
    UUID idOrdem,
    UUID idRequest,
    UUID idCliente,
    String titlo,
    String descricao,
    OrdemStatus ordemStatus,
    LocalDateTime dataCriacao){
}