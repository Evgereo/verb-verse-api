package world.evgereo.verbverse.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.userservice.dto.RegistrationDto;
import world.evgereo.verbverse.userservice.entity.User;
import world.evgereo.verbverse.userservice.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-up")
    public Mono<Void> register(@RequestBody RegistrationDto dto) {
        return null;
    }
}
