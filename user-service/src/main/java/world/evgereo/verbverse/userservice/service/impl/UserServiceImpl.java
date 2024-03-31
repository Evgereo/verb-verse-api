package world.evgereo.verbverse.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.userservice.entity.User;
import world.evgereo.verbverse.userservice.entity.dto.UpdateBirthDateDto;
import world.evgereo.verbverse.userservice.entity.dto.UpdateEmailDto;
import world.evgereo.verbverse.userservice.entity.dto.UpdatePasswordDto;
import world.evgereo.verbverse.userservice.entity.dto.UpdateUsernameDto;
import world.evgereo.verbverse.userservice.repository.UserRepository;
import world.evgereo.verbverse.userservice.service.UserService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Mono<User> getUser(UUID userUuid) {
        return userRepository.findUserAndRoleByUuid(userUuid);
    }

    @Override
    public Mono<User> updateEmail(UpdateEmailDto emailDto, UUID userUuid) {
        return null;
    }

    @Override
    public Mono<User> updatePassword(UpdatePasswordDto passwordDto, UUID userUuid) {
        return null;
    }

    @Override
    public Mono<User> updateUsername(UpdateUsernameDto usernameDto, UUID userUuid) {
        return null;
    }

    @Override
    public Mono<User> updateBirthDate(UpdateBirthDateDto birthDateDto, UUID userUuid) {
        return null;
    }

    @Override
    public Mono<Void> deleteUser(UUID userUuid) {
        return null;
    }
}
