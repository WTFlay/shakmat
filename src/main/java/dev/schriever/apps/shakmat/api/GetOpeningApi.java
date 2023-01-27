package dev.schriever.apps.shakmat.api;

import lombok.Data;

@Data
public class GetOpeningApi {
    private Long id;
    private String name;
    private String moves;
}
