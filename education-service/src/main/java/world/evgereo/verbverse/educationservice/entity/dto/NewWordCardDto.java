package world.evgereo.verbverse.educationservice.entity.dto;

import world.evgereo.verbverse.educationservice.entity.Definition;
import world.evgereo.verbverse.educationservice.entity.Word;

public record NewWordCardDto(
    Word word,

    Definition definition,

    Integer repetitionNumber,

    String image,

    Boolean hidden,

    Boolean favorite) {
}
