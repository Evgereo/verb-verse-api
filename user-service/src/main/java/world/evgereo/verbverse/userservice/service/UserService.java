package world.evgereo.verbverse.userservice.service;

import reactor.core.publisher.Mono;
import world.evgereo.verbverse.userservice.entity.User;
import world.evgereo.verbverse.userservice.entity.dto.UpdateBirthDateDto;
import world.evgereo.verbverse.userservice.entity.dto.UpdateEmailDto;
import world.evgereo.verbverse.userservice.entity.dto.UpdatePasswordDto;
import world.evgereo.verbverse.userservice.entity.dto.UpdateUsernameDto;

import java.util.UUID;

public interface UserService {
    Mono<User> getUser(UUID userUuid);

    Mono<User> updateEmail(UpdateEmailDto emailDto, UUID userUuid);

    Mono<User> updatePassword(UpdatePasswordDto passwordDto, UUID userUuid);

    Mono<User> updateUsername(UpdateUsernameDto usernameDto, UUID userUuid);

    Mono<User> updateBirthDate(UpdateBirthDateDto birthDateDto, UUID userUuid);

    Mono<Void> deleteUser(UUID userUuid);
}
