package world.evgereo.verbverse.educationservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.educationservice.entity.WordSet;
import world.evgereo.verbverse.educationservice.entity.dto.WordSetDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SetController {

    @GetMapping(value = "/latest/sets", params = {"page", "size"})
    public Flux<ResponseEntity<List<WordSet>>> getLatestSets(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                             @RequestParam(value = "size", defaultValue = "10", required = false) int size) {
        return null;
    }

    @GetMapping(value = "{username}/sets", params = {"page", "size"})
    public Flux<ResponseEntity<List<WordSet>>> getUserSets(@PathVariable String username,
                                                           @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                           @RequestParam(value = "size", defaultValue = "10", required = false) int size) {
        return null;
    }

    @GetMapping(value = "{username}/set/{setUUID}")
    public Mono<ResponseEntity<WordSet>> getUserSet(@PathVariable("username") String username,
                                                    @PathVariable("setUUID")UUID setUUID) {
        return null;
    }

    @PostMapping(value = "create-set", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<WordSet>> createSet(@RequestBody WordSetDto wordSetDto) {
        return null;
    }

    @PatchMapping("{username}/set/{setUUID}")
    public Mono<ResponseEntity<WordSet>> createSet(@RequestBody WordSetDto wordSetDto,
                                                   @PathVariable("username") String username,
                                                   @PathVariable("setUUID")UUID setUUID) {
        return null;
    }

    @DeleteMapping("{username}/set/{setUUID}")
    public Mono<ResponseEntity<Void>> deleteSet(@PathVariable("username") String username,
                                                @PathVariable("setUUID")UUID setUUID) {
        return null;
    }
}
