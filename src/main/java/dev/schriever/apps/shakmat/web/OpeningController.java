package dev.schriever.apps.shakmat.web;

import dev.schriever.apps.shakmat.api.GetOpeningApi;
import dev.schriever.apps.shakmat.exception.OpeningNotFoundException;
import dev.schriever.apps.shakmat.mapper.OpeningMapper;
import dev.schriever.apps.shakmat.service.OpeningService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/opening")
public class OpeningController {

    private final OpeningService openingService;
    private final OpeningMapper openingMapper;

    public OpeningController(OpeningService openingService, OpeningMapper openingMapper) {
        this.openingService = openingService;
        this.openingMapper = openingMapper;
    }

    @GetMapping
    public List<GetOpeningApi> getOpenings(@PathParam("moves") String moves) {
        if (moves != null) {
            return openingService.listOpeningByMovesStartsWith(moves)
                    .stream()
                    .map(openingMapper::toDto)
                    .collect(Collectors.toList());
        }
        return openingService.listOpening()
                .stream()
                .map(openingMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public GetOpeningApi getOpening(@PathVariable("id") Long id) {
        try {
            return openingMapper.toDto(openingService.findOpeningById(id));
        } catch (OpeningNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
}
