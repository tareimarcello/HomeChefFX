package logic.exceptions;

public class ChefNotAvailableException extends RuntimeException {
    public ChefNotAvailableException(String message) {
        super(message);
    }
}
