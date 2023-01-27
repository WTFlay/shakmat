package dev.schriever.apps.shakmat.repository;

import dev.schriever.apps.shakmat.entity.Opening;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OpeningRepository extends CrudRepository<Opening, Long> {
  List<Opening> findByMovesContaining(String moves);

  List<Opening> findByMovesStartsWith(String moves);
}
