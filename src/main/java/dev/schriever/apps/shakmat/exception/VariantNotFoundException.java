package dev.schriever.apps.shakmat.exception;

public class VariantNotFoundException extends RuntimeException {
    public VariantNotFoundException(Long id) {
        super("Variant with id \"" + id + "\" is not found");
    }
}
