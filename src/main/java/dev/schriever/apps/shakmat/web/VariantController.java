package dev.schriever.apps.shakmat.web;

import dev.schriever.apps.shakmat.api.GetVariantMovesApi;
import dev.schriever.apps.shakmat.exception.VariantNotFoundException;
import dev.schriever.apps.shakmat.mapper.VariantMapper;
import dev.schriever.apps.shakmat.service.VariantMovesService;
import dev.schriever.apps.shakmat.service.VariantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("variants")
public class VariantController {

    private final VariantService variantService;
    private final VariantMapper variantMapper;

    public VariantController(
            VariantService variantService,
            VariantMapper variantMapper) {
        this.variantService = variantService;
        this.variantMapper = variantMapper;
    }

    @GetMapping("{id}")
    public GetVariantMovesApi getVariantMoves(@PathVariable("id") Long id) {
        try {
            return variantMapper.toDto(variantService.findVariantById(id));
        } catch (VariantNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
}
