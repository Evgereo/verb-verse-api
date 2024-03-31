package world.evgereo.verbverse.userservice.entity.type;

import java.util.HashSet;
import java.util.Set;

public enum RoleTypeImpl implements RoleType {
    STUDENT, TEACHER, WORDSMITH, MODER, ADMIN;

    private final Set<RoleType> children = new HashSet<>();

    static {
        TEACHER.children.add(STUDENT);
        WORDSMITH.children.add(STUDENT);
        MODER.children.addAll(Set.of(RoleTypeImpl.TEACHER, RoleTypeImpl.WORDSMITH));
        ADMIN.children.add(MODER);
    }

    @Override
    public boolean isInclude(RoleType roleType) {
        return this.equals(roleType) || children.stream().anyMatch(r -> r.isInclude(roleType));
    }
}
