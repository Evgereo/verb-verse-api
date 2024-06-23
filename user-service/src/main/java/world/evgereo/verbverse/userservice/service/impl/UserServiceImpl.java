package world.evgereo.verbverse.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.userservice.dto.UserDto;
import world.evgereo.verbverse.userservice.entity.User;
import world.evgereo.verbverse.userservice.exception.NotFoundException;
import world.evgereo.verbverse.userservice.repository.UserRepository;
import world.evgereo.verbverse.userservice.service.UserService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Mono<User> getById(UUID id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + id + " not found")));
    }

    @Override
    public Mono<User> create(UserDto dto) {
        return null;
    }

    @Override
    public Mono<User> update(UUID id, UserDto dto) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(UUID userUuid) {
        return userRepository.deleteById(userUuid);
    }
}
