package world.evgereo.verbverse.educationservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import world.evgereo.verbverse.educationservice.entity.WordCard;

import java.util.UUID;

@Repository
public interface WordCardRepository extends ReactiveCrudRepository<WordCard, UUID> {
}
