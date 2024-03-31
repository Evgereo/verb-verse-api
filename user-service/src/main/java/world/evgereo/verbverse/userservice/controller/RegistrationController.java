package world.evgereo.verbverse.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.userservice.entity.dto.RegistrationDto;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class RegistrationController {

    @PostMapping(value = "signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Void>> createAccount(@RequestBody RegistrationDto registrationDto) {
        return null;
    }

    @GetMapping(value = "/verify/email", params = "token")
    public Mono<ResponseEntity<Void>> verifyEmail(@RequestParam("token") String token) {
        return null;
    }
}
