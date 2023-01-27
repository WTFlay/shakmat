package dev.schriever.apps.shakmat.mapper;

import dev.schriever.apps.shakmat.api.GetVariantMovesApi;
import dev.schriever.apps.shakmat.entity.Opening;
import dev.schriever.apps.shakmat.entity.Variant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VariantMapper {
    GetVariantMovesApi toDto(Variant variant);

    default String map(Opening opening) {
        return opening.getName();
    }
}
