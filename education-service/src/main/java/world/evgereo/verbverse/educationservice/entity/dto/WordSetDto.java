package world.evgereo.verbverse.educationservice.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import world.evgereo.verbverse.educationservice.entity.WordCard;
import world.evgereo.verbverse.educationservice.entity.WordSet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
public class WordSetDto {
    private UUID uuid;

    private String setName;

    private String description;

    private WordSet.PublicityType publicityType;

    private WordSet.LearningStrategy learningStrategy;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    private LocalDate endGoal;

    private Set<WordCard> wordCards;
}
