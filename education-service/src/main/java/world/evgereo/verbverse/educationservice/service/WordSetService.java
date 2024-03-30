package world.evgereo.verbverse.educationservice.service;

import org.springframework.data.domain.Page;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.educationservice.entity.WordSet;
import world.evgereo.verbverse.educationservice.entity.dto.NewWordSetDto;

import java.util.UUID;

public interface WordSetService {
    Mono<Page<WordSet>> getLatestPageSets(int page, int size);

    Mono<Page<WordSet>> getUserSets(UUID authorUuid, int page, int size);

    Mono<WordSet> getSet(UUID setUuid);

    Mono<WordSet> createSet(Mono<NewWordSetDto> wordSetDto, UUID authorUuid);

    Mono<WordSet> updateSet(Mono<NewWordSetDto> wordSetDto, UUID setUuid);

    Mono<Void> deleteSet(UUID setUuid);
}
