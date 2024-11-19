package logic.exceptions;

public class MailAlreadyUsed extends RuntimeException {
    public MailAlreadyUsed(String message) {
        super(message);
    }
}
