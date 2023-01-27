package dev.schriever.apps.shakmat.service;

import dev.schriever.apps.shakmat.entity.Variant;
import dev.schriever.apps.shakmat.exception.VariantNotFoundException;
import dev.schriever.apps.shakmat.repository.VariantRepository;
import org.springframework.stereotype.Service;

@Service
public class VariantServiceImpl implements VariantService {

    private final VariantRepository variantRepository;
    private final VariantMovesService variantMovesService;

    public VariantServiceImpl(
            VariantRepository variantRepository,
            VariantMovesService variantMovesService
    ) {
        this.variantRepository = variantRepository;
        this.variantMovesService = variantMovesService;
    }

    @Override
    public Variant findVariantById(Long id) {
        var variant = variantRepository.findById(id).orElseThrow(() -> new VariantNotFoundException(id));
        String completeMoves = variantMovesService.getCompleteMoves(variant);
        variant.setMoves(completeMoves);
        return variant;
    }
}
