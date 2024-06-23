package world.evgereo.verbverse.userservice.dto;

import java.time.LocalDateTime;

public record UserDto(
        String username,

        String email,

        LocalDateTime birthDate
) {
}
