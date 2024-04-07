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
import world.evgereo.verbverse.userservice.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{userUuid:^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$}")
    public Mono<ResponseEntity<User>> getUser(@PathVariable("userUuid") UUID userUuid) {
        return userService.getUser(userUuid)
                .map(ResponseEntity::ok);
    }

    @PatchMapping(value = "/{userUuid:^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$}/email",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<User>> updateEmail(@RequestBody UpdateEmailDto emailDto,
                                                 @PathVariable("userUuid") UUID userUuid) {
        return userService.updateEmail(emailDto, userUuid)
                .map(ResponseEntity::ok);
    }

    @PatchMapping(value = "/{userUuid:^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$}/password",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<User>> updatePassword(@RequestBody UpdatePasswordDto passwordDto,
                                                  @PathVariable("userUuid") UUID userUuid) {
        return userService.updatePassword(passwordDto, userUuid)
                .map(ResponseEntity::ok);
    }

    @PatchMapping(value = "/{userUuid:^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$}/username",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<User>> updateUsername(@RequestBody UpdateUsernameDto usernameDto,
                                                     @PathVariable("userUuid") UUID userUuid) {
        return userService.updateUsername(usernameDto, userUuid)
                .map(ResponseEntity::ok);
    }

    @PatchMapping(value = "/{userUuid:^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$}/birth-date",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<User>> updateBirthDate(@RequestBody UpdateBirthDateDto birthDateDto,
                                                     @PathVariable("userUuid") UUID userUuid) {
        return userService.updateBirthDate(birthDateDto, userUuid)
                .map(ResponseEntity::ok);
    }

    @DeleteMapping(value = "/{userUuid:^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$})")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable("userUuid") UUID userUuid) {
        return userService.deleteUser(userUuid)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }
}
