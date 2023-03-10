package dev.schriever.apps.shakmat.service;

import dev.schriever.apps.shakmat.entity.Opening;
import dev.schriever.apps.shakmat.exception.OpeningNotFoundException;
import dev.schriever.apps.shakmat.repository.OpeningRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpeningServiceImpl implements OpeningService {

  private final OpeningRepository openingRepository;

  public OpeningServiceImpl(OpeningRepository openingRepository) {
    this.openingRepository = openingRepository;
  }

  @Override
  public List<Opening> listOpening(String moves) {
    if (moves != null) {
      return openingRepository.findByMovesStartsWith(moves);
    }
    return (List<Opening>) openingRepository.findAll();
  }

  @Override
  public Opening findOpeningById(Long id) {
    return openingRepository.findById(id).orElseThrow(() -> new OpeningNotFoundException(id));
  }
}
