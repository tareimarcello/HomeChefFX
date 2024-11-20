package logic.exceptions;

public class ChefNotAvailableException extends RuntimeException {
    private static final long serialVersionUID = 6L;
    public ChefNotAvailableException(String message) {
        super(message);
    }
}
