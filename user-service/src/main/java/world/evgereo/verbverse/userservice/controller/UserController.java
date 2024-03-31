package world.evgereo.verbverse.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.userservice.entity.User;
import world.evgereo.verbverse.userservice.entity.dto.UpdateBirthDateDto;
import world.evgereo.verbverse.userservice.entity.dto.UpdateEmailDto;
import world.evgereo.verbverse.userservice.entity.dto.UpdatePasswordDto;
import world.evgereo.verbverse.userservice.entity.dto.UpdateUsernameDto;
import world.evgereo.verbverse.userservice.service.impl.UserServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @GetMapping("/{userUuid}")
    public Mono<ResponseEntity<User>> getUser(@PathVariable("userUuid") UUID userUuid) {
        return userServiceImpl.getUser(userUuid)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PatchMapping(value = "/{userUuid}/email", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<User>> updateEmail(@RequestBody UpdateEmailDto emailDto,
                                                 @PathVariable("userUuid") UUID userUuid) {
        return null;
    }

    @PatchMapping(value = "/{userUuid}/password", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<User>> updatePassword(@RequestBody UpdatePasswordDto passwordDto,
                                                  @PathVariable("userUuid") UUID userUuid) {
        return null;
    }

    @PatchMapping(value = "/{userUuid}/username", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<User>> updateUsername(@RequestBody UpdateUsernameDto usernameDto,
                                                     @PathVariable("userUuid") UUID userUuid) {
        return null;
    }

    @PatchMapping(value = "/{userUuid}/birth-date", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<User>> updateBirthDate(@RequestBody UpdateBirthDateDto birthDateDto,
                                                     @PathVariable("userUuid") UUID userUuid) {
        return null;
    }

    @DeleteMapping(value = "/{userUuid})")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable("userUuid") UUID userUuid) {
        return null;
    }
}
