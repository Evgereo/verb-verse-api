package world.evgereo.verbverse.userservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import world.evgereo.verbverse.userservice.entity.type.RoleTypeImpl;

@NoArgsConstructor
@Table("role")
public class Role {
    @Id
    @Getter
    @Setter
    @Column("id")
    private Integer id;

    @Column("role_name")
    private String roleName;

    @Transient
    private RoleTypeImpl roleType;

    public Role(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public RoleTypeImpl getRole() {
        if (roleType == null) {
            roleType = RoleTypeImpl.valueOf(roleName);
        }
        return roleType;
    }

    public void setRole(RoleTypeImpl role) {
        roleType = role;
        roleName = role.name();
    }
}
