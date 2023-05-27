package ro.vinyl.backend.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
    // Additional constructors or methods can be added as needed
}
