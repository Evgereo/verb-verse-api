package world.evgereo.verbverse.userservice.enumeration;

public interface RoleType {
    boolean isInclude(RoleType roleType);

    String name();
}
