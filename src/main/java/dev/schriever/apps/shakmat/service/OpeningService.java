package dev.schriever.apps.shakmat.service;

import dev.schriever.apps.shakmat.entity.Opening;

import java.util.List;

public interface OpeningService {
    List<Opening> listOpening();
    Opening findOpeningById(Long id);

    List<Opening> listOpeningByMovesStartsWith(String moves);
}
