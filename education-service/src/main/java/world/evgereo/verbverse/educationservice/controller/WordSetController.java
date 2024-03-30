package world.evgereo.verbverse.educationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.educationservice.entity.WordSet;
import world.evgereo.verbverse.educationservice.entity.dto.NewWordSetDto;
import world.evgereo.verbverse.educationservice.service.impl.WordSetServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class WordSetController {
    private final WordSetServiceImpl wordSetService;

    @GetMapping(value = "/latest/sets", params = {"page", "size"})
    public Mono<ResponseEntity<List<WordSet>>> getLatestSets(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                             @RequestParam(value = "size", defaultValue = "10", required = false) int size) {
        return wordSetService.getLatestPageSets(page, size).flatMap(pageable ->
                Mono.just(new ResponseEntity<>(pageable.getContent(), HttpStatus.OK))); // add headers
    }

    @GetMapping(value = "/{username}/sets", params = {"page", "size"})
    public Mono<ResponseEntity<List<WordSet>>> getUserSets(@PathVariable String username,
                                                           @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                           @RequestParam(value = "size", defaultValue = "10", required = false) int size) {
        return null;
    }

    @GetMapping(value = "/sets/{setUuid}")
    public Mono<ResponseEntity<WordSet>> getSet(@PathVariable("setUuid") UUID setUuid) {
        return wordSetService.getSet(setUuid).flatMap(wordSet ->
                Mono.just(ResponseEntity.ok(wordSet)));
    }

    @PostMapping(value = "/create-set", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<WordSet>> createSet(@RequestBody Mono<NewWordSetDto> wordSetDto,
                                                   UriComponentsBuilder uriComponentsBuilder) {
        return wordSetService.createSet(wordSetDto, null).flatMap(wordSet ->
                Mono.just(ResponseEntity
                        .created(uriComponentsBuilder.replacePath("/sets/{setUuid}").build(wordSet.getUuid()))
                        .body(wordSet)));
    }

    @PatchMapping(value = "/sets/{setUuid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<WordSet>> updateSet(@RequestBody Mono<NewWordSetDto> wordSetDto,
                                                   @PathVariable("setUuid") UUID setUuid) {
        return wordSetService.updateSet(wordSetDto, setUuid).flatMap(wordSet ->
                Mono.just(ResponseEntity.ok(wordSet)));
    }

    @DeleteMapping("/sets/{setUuid}")
    public Mono<ResponseEntity<Void>> deleteSet(@PathVariable("setUuid") UUID setUUID) {
        return wordSetService.deleteSet(setUUID).then(Mono.just(ResponseEntity.noContent().build()));
    }
}
