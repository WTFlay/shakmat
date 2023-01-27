package dev.schriever.apps.shakmat.api;

import lombok.Data;

@Data
public class GetVariantMovesApi {
    private Long id;
    private String opening;
    private String moves;
}
