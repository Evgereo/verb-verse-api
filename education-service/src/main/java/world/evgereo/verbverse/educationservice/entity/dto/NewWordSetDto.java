package world.evgereo.verbverse.educationservice.entity.dto;

import world.evgereo.verbverse.educationservice.entity.WordCard;
import world.evgereo.verbverse.educationservice.entity.WordSet;

import java.time.LocalDate;
import java.util.List;

public record NewWordSetDto(
    String setName,

    String description,

    WordSet.PublicityType publicityType,

    WordSet.LearningStrategy learningStrategy,

    LocalDate endGoal,

    List<WordCard> wordCards) {
}
