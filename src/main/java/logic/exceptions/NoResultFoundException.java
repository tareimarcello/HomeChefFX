package logic.exceptions;

public class NoResultFoundException extends RuntimeException {
  private static final long serialVersionUID = 7L;
    public NoResultFoundException(String message) {
        super(message);
    }
}
