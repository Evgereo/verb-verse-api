package world.evgereo.verbverse.userservice.entity.dto;

import java.time.LocalDateTime;

public record RegistrationDto(
        String username,

        String email,

        String password,

        String passwordConfirm,

        LocalDateTime birthDate) {
}
