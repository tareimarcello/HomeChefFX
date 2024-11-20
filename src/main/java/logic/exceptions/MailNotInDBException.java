package logic.exceptions;

public class MailNotInDBException extends RuntimeException {
    private static final long serialVersionUID = 3L;
    public MailNotInDBException(String message) {
        super(message);
    }
}
