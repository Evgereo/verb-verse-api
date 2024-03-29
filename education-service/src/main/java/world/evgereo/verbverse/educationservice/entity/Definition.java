package world.evgereo.verbverse.educationservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("definition")
public class Definition {
    @Id
    @Column("id")
    private Long id;

    @Column("word_definition_id")
    private Long wordDefinitionId;

    @Column("example_id")
    private Long exampleId;
}
