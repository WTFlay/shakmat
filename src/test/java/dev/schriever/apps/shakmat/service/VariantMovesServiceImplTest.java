package dev.schriever.apps.shakmat.service;

import dev.schriever.apps.shakmat.entity.Opening;
import dev.schriever.apps.shakmat.entity.Variant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VariantMovesServiceImplTest {

  @Autowired private VariantMovesServiceImpl service;

  @Test
  public void whenGetCompleteMoves_thenAddOpeningMoves() {
    var variant = buildOpeningWithVariants("e5 e4", "Cf3 Cc6");

    String moves = service.getCompleteMoves(variant);

    assertEquals("e5 e4 Cf3 Cc6", moves);
  }

  @Test
  public void whenGetCompleteMoves_thenAddOpeningAndParentVariant() {
    var variant = buildOpeningWithVariants("e5 e4", "Cf3 Cc6", "d4 exd4");

    String moves = service.getCompleteMoves(variant);

    assertEquals("e5 e4 Cf3 Cc6 d4 exd4", moves);
  }

  @Test
  public void whenGetCompleteMoves_thenAddOpeningAndAllVariants() {
    var variant =
        buildOpeningWithVariants("e5 e4", "Cf3 Cc6", "d4 exd4", "Cxd4", "Fc5", "Fe3 Df6 c3 Cge7");

    String moves = service.getCompleteMoves(variant);

    assertEquals("e5 e4 Cf3 Cc6 d4 exd4 Cxd4 Fc5 Fe3 Df6 c3 Cge7", moves);
  }

  private Variant buildOpeningWithVariants(String openingMoves, String... variantsMoves) {
    var opening = Opening.builder().moves(openingMoves).build();
    Variant lastVariant = null;
    for (String moves : variantsMoves) {
      var variant = Variant.builder().moves(moves).build();
      variant.setOpening(opening);
      if (lastVariant != null) {
        variant.setParentVariant(lastVariant);
      }
      lastVariant = variant;
    }
    return lastVariant;
  }
}
