package dev.schriever.apps.shakmat.service;

import dev.schriever.apps.shakmat.entity.Variant;
import dev.schriever.apps.shakmat.exception.VariantNotFoundException;
import dev.schriever.apps.shakmat.repository.VariantRepository;
import org.springframework.stereotype.Service;

@Service
public class VariantServiceImpl implements VariantService {

    private final VariantRepository variantRepository;

    public VariantServiceImpl(VariantRepository variantRepository) {
        this.variantRepository = variantRepository;
    }

    @Override
    public Variant findVariantById(Long id) {
        return variantRepository.findById(id).orElseThrow(() -> new VariantNotFoundException(id));
    }
}
