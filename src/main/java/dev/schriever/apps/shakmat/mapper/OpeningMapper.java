package dev.schriever.apps.shakmat.mapper;

import dev.schriever.apps.shakmat.dto.GetOpeningDto;
import dev.schriever.apps.shakmat.entity.Opening;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OpeningMapper {
    GetOpeningDto toDto(Opening opening);
}
