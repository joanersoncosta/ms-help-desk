package com.github.joanersoncosta.apiordem.ordem.application.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.github.joanersoncosta.apiordem.ordem.application.api.response.NovaOrdemReIdsponse;
import com.github.joanersoncosta.apiordem.ordem.domain.Ordem;

@Mapper(componentModel = "spring", 
	nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, 
	nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrdemMapper {
	@Mapping(source = "idOrdem", target = "idOrdem")
	NovaOrdemReIdsponse fromIdOrdemResponse(Ordem ordem);
}