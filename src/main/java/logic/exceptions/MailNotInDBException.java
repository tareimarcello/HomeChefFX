package logic.exceptions;

public class MailNotInDBException extends RuntimeException {
    public MailNotInDBException(String message) {
        super(message);
    }
}
