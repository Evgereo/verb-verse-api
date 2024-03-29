package world.evgereo.verbverse.educationservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import world.evgereo.verbverse.educationservice.entity.type.DifficultyLevel;
import world.evgereo.verbverse.educationservice.entity.type.Lang;

@Getter
@Setter
@Table("word_definition")
public class WordDefinition {
    @Id
    @Column("id")
    private Long id;

    @Column("word_id")
    private Long wordId;

    @Column("definition")
    private String definition;

    @Column("lang")
    private Lang lang;

    @Column("difficulty_level")
    private DifficultyLevel difficultyLevel;
}
