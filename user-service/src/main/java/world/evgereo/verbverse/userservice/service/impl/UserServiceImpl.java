package world.evgereo.verbverse.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.userservice.entity.User;
import world.evgereo.verbverse.userservice.entity.dto.UpdateBirthDateDto;
import world.evgereo.verbverse.userservice.entity.dto.UpdateEmailDto;
import world.evgereo.verbverse.userservice.entity.dto.UpdatePasswordDto;
import world.evgereo.verbverse.userservice.entity.dto.UpdateUsernameDto;
import world.evgereo.verbverse.userservice.exception.BadRequestException;
import world.evgereo.verbverse.userservice.exception.NotFoundException;
import world.evgereo.verbverse.userservice.repository.UserRepository;
import world.evgereo.verbverse.userservice.service.UserService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Mono<User> getUser(UUID userUuid) {
        return userRepository.findById(userUuid)
                .switchIfEmpty(Mono.error(new NotFoundException("User not found")));
    }

    @Override
    @Transactional
    public Mono<User> updateEmail(UpdateEmailDto emailDto, UUID userUuid) {
        return getUser(userUuid)
                .flatMap(user -> {
                    user.setEmail(emailDto.email());
                    return userRepository.save(user);
                })
                .onErrorResume(NotFoundException.class, error -> {
                    throw new BadRequestException(error.getMessage());
                }); // send email verify
    }

    @Override
    public Mono<User> updatePassword(UpdatePasswordDto passwordDto, UUID userUuid) {
        return getUser(userUuid)
                .flatMap(user -> {
                    if (user.getPassword().equals(passwordDto.previousPassword())) {
                        if (passwordDto.password().equals(passwordDto.passwordConfirm())) {
                            user.setPassword(passwordDto.password());
                            return userRepository.save(user);
                        }
                        return Mono.error(new BadRequestException("New passwords don't match"));
                    }
                    return Mono.error(new BadRequestException("You've entered wrong previous password"));
                })
                .onErrorResume(NotFoundException.class, error -> {
                    throw new BadRequestException(error.getMessage());
                });
    }

    @Override
    public Mono<User> updateUsername(UpdateUsernameDto usernameDto, UUID userUuid) {
        return getUser(userUuid)
                .flatMap(user -> userRepository.existsByUsername(usernameDto.username())
                        .flatMap(isExist -> {
                            if(isExist) {
                                return Mono.error(new BadRequestException("A user with that name exists"));
                            }
                            return userRepository.save(user);
                        }))
                .onErrorResume(NotFoundException.class, error -> {
                    throw new BadRequestException(error.getMessage());
                });
    }

    @Override
    public Mono<User> updateBirthDate(UpdateBirthDateDto birthDateDto, UUID userUuid) {
        return getUser(userUuid)
                .flatMap(user -> {
                    user.setBirthDate(birthDateDto.birthDate());
                    return userRepository.save(user);
                })
                .onErrorResume(NotFoundException.class, error -> {
                    throw new BadRequestException(error.getMessage());
                });
    }

    @Override
    public Mono<Void> deleteUser(UUID userUuid) {
        return userRepository.deleteById(userUuid);
    }
}
