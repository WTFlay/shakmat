package dev.schriever.apps.shakmat.dto;

import lombok.Data;

@Data
public class GetOpeningDto {
    private Long id;
    private String name;
    private String moves;
}
