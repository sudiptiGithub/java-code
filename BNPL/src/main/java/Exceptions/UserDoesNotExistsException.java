package Exceptions;

public class UserDoesNotExistsException extends RuntimeException{

    public UserDoesNotExistsException(String message) {
        super(message);
    }
}
