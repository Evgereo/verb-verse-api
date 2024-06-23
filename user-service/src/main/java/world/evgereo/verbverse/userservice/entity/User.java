package world.evgereo.verbverse.userservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import world.evgereo.verbverse.userservice.enumeration.RoleType;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Table("account")
public class User {
    @Id
    @Column("user_id")
    private UUID id;

    private String name;

    private String email;

    private LocalDateTime birthDate;

    private LocalDateTime createdAt;

    @Column("is_active")
    private Boolean active;

    private RoleType role;
}
