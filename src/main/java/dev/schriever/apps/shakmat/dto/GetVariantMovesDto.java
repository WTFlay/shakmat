package dev.schriever.apps.shakmat.dto;

import lombok.Data;

@Data
public class GetVariantMovesDto {
    private Long id;
    private String opening;
    private String moves;
}
