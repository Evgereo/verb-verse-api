package world.evgereo.verbverse.educationservice.service;

import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.educationservice.entity.WordCard;
import world.evgereo.verbverse.educationservice.entity.dto.NewWordCardDto;

import java.util.UUID;

public interface WordCardService {
    Mono<Page<WordCard>> getUserCards(UUID authorUuid, int page, int size);

    Flux<WordCard> getFavoriteUserCards(UUID authorUuid);

    Mono<WordCard> getCard(UUID cardUuid);

    Mono<WordCard> createCard(Mono<NewWordCardDto> wordCardDto, UUID authorUuid);

    Mono<WordCard> makeFavorite(UUID cardUuid, Boolean favorite);

    Mono<WordCard> makeHidden(UUID cardUuid, Boolean hidden);

    Mono<WordCard> increaseRepetitionNumber(UUID cardUuid);

    Mono<WordCard> resetRepetitionNumber(UUID cardUuid);

    Mono<WordCard> updateCard(Mono<NewWordCardDto> wordCardDto, UUID cardUuid);

    Mono<Void> deleteCard(UUID cardUuid);
}
