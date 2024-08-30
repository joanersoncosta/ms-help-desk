package com.github.joanersoncosta.apiordem.ordem.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.github.joanersoncosta.apiordem.ordem.application.api.request.NovaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.application.api.response.NovaOrdemReIdsponse;
import com.github.joanersoncosta.apiordem.ordem.domain.enuns.OrdemStatus;

@Mapper(componentModel = "spring", 
	nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, 
	nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrdemMapper {
	@Mapping(target = "idOrdem", ignore = true)
	@Mapping(target = "ordemStatus", constant = "ABERTO")
    @Mapping(target = "dataCriacao", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "dataFechamento", ignore = true)
	Ordem fromOrdemRequest(NovaOrdemRequest novaOrdemRequest);
	@Mapping(source = "idOrdem", target = "idOrdem")
	NovaOrdemReIdsponse fromIdOrdemResponse(Ordem ordem);
	@Named("mapStatus")
	default OrdemStatus mapStatus(String Aberto) {
		return OrdemStatus.toEnum(Aberto);
	}
}