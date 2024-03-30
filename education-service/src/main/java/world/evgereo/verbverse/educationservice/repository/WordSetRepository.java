package world.evgereo.verbverse.educationservice.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import world.evgereo.verbverse.educationservice.entity.WordSet;

import java.util.UUID;

@Repository
public interface WordSetRepository extends ReactiveCrudRepository<WordSet, UUID> {
    Flux<WordSet> findAllBy(Pageable pageable);

    Flux<WordSet> findAllByAuthorUuid(UUID authorUuid, Pageable pageable);
}
