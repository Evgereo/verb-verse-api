package world.evgereo.verbverse.userservice.service;

import reactor.core.publisher.Mono;
import world.evgereo.verbverse.userservice.dto.UserDto;
import world.evgereo.verbverse.userservice.entity.User;

import java.util.UUID;

public interface UserService {

    Mono<User> getById(UUID id);

    Mono<User> create(UserDto dto);

    Mono<User> update(UUID id, UserDto dto);

    Mono<Void> deleteById(UUID id);
}
