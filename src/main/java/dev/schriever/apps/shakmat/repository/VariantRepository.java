package dev.schriever.apps.shakmat.repository;

import dev.schriever.apps.shakmat.entity.Variant;
import org.springframework.data.repository.CrudRepository;

public interface VariantRepository extends CrudRepository<Variant, Long> {
}
