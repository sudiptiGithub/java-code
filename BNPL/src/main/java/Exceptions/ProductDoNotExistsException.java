package Exceptions;

public class ProductDoNotExistsException extends RuntimeException {
    public ProductDoNotExistsException(String message) {
        super(message);
    }
}
