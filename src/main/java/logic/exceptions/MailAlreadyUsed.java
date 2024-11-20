package logic.exceptions;

public class MailAlreadyUsed extends RuntimeException {
    private static final long serialVersionUID = 2L;
    public MailAlreadyUsed(String message) {
        super(message);
    }
}
