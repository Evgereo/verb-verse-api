package world.evgereo.verbverse.educationservice.entity.dto;

import lombok.Getter;
import lombok.Setter;
import world.evgereo.verbverse.educationservice.entity.WordCard;
import world.evgereo.verbverse.educationservice.entity.WordSet;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class NewWordSetDto {
    private String setName;

    private String description;

    private WordSet.PublicityType publicityType;

    private WordSet.LearningStrategy learningStrategy;

    private LocalDate endGoal;

    private List<WordCard> wordCards;
}
