package world.evgereo.verbverse.userservice.entity.dto;

public record UpdatePasswordDto(
        String previousPassword,

        String password,

        String passwordConfirm) {
}
