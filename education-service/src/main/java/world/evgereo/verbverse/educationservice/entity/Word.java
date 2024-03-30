package world.evgereo.verbverse.educationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import world.evgereo.verbverse.educationservice.entity.type.DifficultyLevel;
import world.evgereo.verbverse.educationservice.entity.type.Lang;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("word")
public class Word {
    @Id
    @Column("word_id")
    private Long id;

    @Column("word")
    private String word;

    @Column("lang")
    private Lang lang;

    @Column("approved")
    private Boolean approved;

    @Column("speech_part")
    private SpeechPart speechPart;

    @Column("difficulty_level")
    private DifficultyLevel difficultyLevel;

    public enum SpeechPart {
        NOUN,
        PRONOUN,
        ADJECTIVE,
        VERB,
        ADVERB,
        PREPOSITION,
        CONJUNCTION,
        ARTICLE
    }
}
