package world.evgereo.verbverse.userservice.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.userservice.exception.BadRequestException;
import world.evgereo.verbverse.userservice.exception.NotFoundException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public Mono<ResponseEntity<?>> badRequestException(BadRequestException ex) {
        return Mono.just(new ResponseEntity<>(Map.of("message", ex.getMessage()), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(NotFoundException.class)
    public Mono<ResponseEntity<?>> notFoundHandler(NotFoundException ex) {
        return Mono.just(new ResponseEntity<>(Map.of("message", ex.getMessage()), HttpStatus.NOT_FOUND));
    }
}
