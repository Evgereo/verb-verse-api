package world.evgereo.verbverse.educationservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import world.evgereo.verbverse.educationservice.entity.Word;

@Repository
public interface WordRepository extends ReactiveCrudRepository<Word, Long> {
}
