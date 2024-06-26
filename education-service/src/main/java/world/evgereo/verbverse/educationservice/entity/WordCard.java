package world.evgereo.verbverse.educationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("word_card")
public class WordCard {
    @Id
    @Column("uuid")
    private UUID uuid;

    @Column("author_uuid")
    private UUID authorUuid;

    @Column("word_id")
    private Word word;

    @Column("description_id")
    private Definition definition;

    @Column("repetition_number")
    private Integer repetitionNumber;

    @Column("image")
    private String image;

    @Column("hidden")
    private Boolean hidden;

    @Column("favorite")
    private Boolean favorite;
}
