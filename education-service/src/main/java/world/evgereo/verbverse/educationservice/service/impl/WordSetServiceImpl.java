package world.evgereo.verbverse.educationservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.educationservice.entity.WordSet;
import world.evgereo.verbverse.educationservice.entity.dto.NewWordSetDto;
import world.evgereo.verbverse.educationservice.repository.WordSetRepository;
import world.evgereo.verbverse.educationservice.service.WordSetService;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WordSetServiceImpl implements WordSetService {
    private final WordSetRepository wordSetRepository;

    @Override
    public Mono<Page<WordSet>> getLatestPageSets(int page, int size) {
        return Mono.just(PageRequest.of(page, size))
                .flatMap(pageRequest -> wordSetRepository.findAllBy(pageRequest)
                        .collectList()
                        .zipWith(wordSetRepository.count())
                        .map(p -> new PageImpl<>(p.getT1(), pageRequest, p.getT2())));
    }

    @Override
    public Mono<Page<WordSet>> getUserSets(UUID authorUuid, int page, int size) {
        return Mono.just(PageRequest.of(page, size))
                .flatMap(pageRequest -> wordSetRepository.findAllByAuthorUuid(authorUuid, pageRequest)
                        .collectList()
                        .zipWith(wordSetRepository.count())
                        .map(p -> new PageImpl<>(p.getT1(), pageRequest, p.getT2())));
    }

    @Override
    public Mono<WordSet> getSet(UUID setUuid) {
        return wordSetRepository.findById(setUuid);
    }

    @Override
    public Mono<WordSet> createSet(Mono<NewWordSetDto> wordSetDto, UUID authorUuid) {
        return wordSetDto.flatMap(dto ->
                wordSetRepository.save(WordSet.builder()
                        .uuid(UUID.randomUUID())
                        .authorUuid(null) //add author later
                        .setName(dto.getSetName())
                        .description(dto.getDescription())
                        .publicityType(dto.getPublicityType())
                        .learningStrategy(dto.getLearningStrategy())
                        .endGoal(dto.getEndGoal())
                        .build())
        );
    }

    @Override
    public Mono<WordSet> updateSet(Mono<NewWordSetDto> wordSetDto, UUID setUuid) {
        return wordSetRepository.existsById(setUuid).flatMap(exist -> {
            if(exist) {
                return wordSetDto.flatMap(dto ->
                        wordSetRepository.save(WordSet.builder()
                                .uuid(setUuid)
                                .authorUuid(null) //add author later
                                .setName(dto.getSetName())
                                .description(dto.getDescription())
                                .publicityType(dto.getPublicityType())
                                .learningStrategy(dto.getLearningStrategy())
                                .updateAt(LocalDateTime.now())
                                .endGoal(dto.getEndGoal())
                                .build())
                );
            }
            else {
                return Mono.empty(); // update request status
            }
        });
    }

    @Override
    public Mono<Void> deleteSet(UUID setUuid) {
        return wordSetRepository.deleteById(setUuid);
    }
}


