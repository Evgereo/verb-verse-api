package world.evgereo.verbverse.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.userservice.dto.UserDto;
import world.evgereo.verbverse.userservice.entity.User;
import world.evgereo.verbverse.userservice.service.UserService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable UUID id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    public Mono<User> update(@PathVariable UUID id,
                             @RequestBody UserDto dto) {
        return null;
    }

    @DeleteMapping("/{id})")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteById(@PathVariable UUID id) {
        return userService.deleteById(id);
    }
}
