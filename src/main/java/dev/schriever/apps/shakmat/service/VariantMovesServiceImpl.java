package dev.schriever.apps.shakmat.service;

import dev.schriever.apps.shakmat.entity.Variant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VariantMovesServiceImpl implements VariantMovesService {
    @Override
    public String getCompleteMoves(Variant variant) {
        List<String> moves = new ArrayList<>();
        moves.add(variant.getOpening().getMoves());
        moves.addAll(getAllParentsMoves(new ArrayList<>(), variant));
        return String.join(" ", moves);
    }

    private List<String> getAllParentsMoves(List<String> parentMoves, Variant variant) {
        parentMoves.add(variant.getMoves());
        if (variant.getParentVariant() != null) {
            return getAllParentsMoves(parentMoves, variant.getParentVariant());
        }
        Collections.reverse(parentMoves);
        return parentMoves;
    }
}
