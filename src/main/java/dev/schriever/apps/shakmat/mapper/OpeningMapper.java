package dev.schriever.apps.shakmat.mapper;

import dev.schriever.apps.shakmat.api.GetOpeningApi;
import dev.schriever.apps.shakmat.entity.Opening;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OpeningMapper {
    GetOpeningApi toDto(Opening opening);
}
