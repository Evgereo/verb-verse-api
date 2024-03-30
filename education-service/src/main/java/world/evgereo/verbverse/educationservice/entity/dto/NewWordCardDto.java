package world.evgereo.verbverse.educationservice.entity.dto;

import lombok.Getter;
import lombok.Setter;
import world.evgereo.verbverse.educationservice.entity.Definition;
import world.evgereo.verbverse.educationservice.entity.Word;

@Getter
@Setter
public class NewWordCardDto {
    private Word word;

    private Definition definition;

    private Integer repetitionNumber;

    private String image;

    private Boolean hidden;

    private Boolean favorite;
}
