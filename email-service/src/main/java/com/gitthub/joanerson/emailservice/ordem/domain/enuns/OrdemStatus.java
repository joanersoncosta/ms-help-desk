package com.gitthub.joanerson.emailservice.ordem.domain.enuns;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum OrdemStatus {
    ABERTO("Aberto"),
    EM_PROGRESSO("Em progresso"),
    FECHADO("Fechado"),
    CANCELADO("Cancelado");

    @Getter
    private String descricao;
}
