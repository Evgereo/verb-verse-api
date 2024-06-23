package world.evgereo.verbverse.userservice.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;
import world.evgereo.verbverse.userservice.dto.ExceptionMessageDto;
import world.evgereo.verbverse.userservice.exception.BadRequestException;
import world.evgereo.verbverse.userservice.exception.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public Mono<ExceptionMessageDto> badRequestException(BadRequestException ex) {
        return Mono.just(new ExceptionMessageDto(ex.getMessage()));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Mono<ExceptionMessageDto> notFoundHandler(NotFoundException ex) {
        return Mono.just(new ExceptionMessageDto(ex.getMessage()));
    }
}
