package world.evgereo.verbverse.educationservice.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("set")
public class WordSet {
    @Id
    @Column("uuid")
    private UUID uuid;

    @Column("author_uuid")
    private UUID authorUuid;

    @Column("set_name")
    private String setName;

    @Column("description")
    private String description;

    @Column("publicity_type")
    private PublicityType publicityType;

    @Column("learning_strategy")
    private LearningStrategy learningStrategy;

    @Column("created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column("updated_at")
    @LastModifiedDate
    private LocalDateTime updateAt;

    @Column("end_goal")
    private LocalDate endGoal;

    public enum PublicityType {
        PRIVATE,
        PUBLIC
    }

    public enum LearningStrategy {
        CONSTANTLY,
        PERIODICALLY,
        PASSIVELY
    }
}
