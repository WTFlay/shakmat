package dev.schriever.apps.shakmat.mapper;

import dev.schriever.apps.shakmat.dto.GetVariantMovesDto;
import dev.schriever.apps.shakmat.entity.Opening;
import dev.schriever.apps.shakmat.entity.Variant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VariantMapper {
    GetVariantMovesDto toDto(Variant variant);

    default String map(Opening opening) {
        return opening.getName();
    }
}
