package world.evgereo.verbverse.userservice.exception;

public class BadRequestException extends ClientException {

    public BadRequestException(String message) {
        super(message);
    }
}
