package world.evgereo.verbverse.userservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.joselion.springr2dbcrelationships.annotations.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("account")
public class User {
    @Id
    @Column("uuid")
    private UUID uuid;

    @Column("username")
    private String username;

    @Column("email")
    private String email;

    @Column("password")
    private String password;

    @Column("birth_date")
    private LocalDateTime birthDate;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("active")
    private Boolean active;

    @Column("role_id")
    @JsonIgnore
    private Integer roleId; // unused field

    @ManyToOne // n+1 problem
    private Role role;
}
