package com.gitthub.joanerson.emailservice.ordem.domain.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class OrdemCriadaResponse{
    private OrdemResponse ordemResponse;
    private UsuarioResponse tecnicoResponse;
    private UsuarioResponse clienteResponse;
}