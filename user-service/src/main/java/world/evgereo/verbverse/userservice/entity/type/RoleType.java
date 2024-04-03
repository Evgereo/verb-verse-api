package world.evgereo.verbverse.userservice.entity.type;

public interface RoleType {
    boolean isInclude(RoleType roleType);

    String name();
}
