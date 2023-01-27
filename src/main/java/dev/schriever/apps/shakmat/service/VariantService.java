package dev.schriever.apps.shakmat.service;

import dev.schriever.apps.shakmat.entity.Variant;

public interface VariantService {
    Variant findVariantById(Long id);
}
