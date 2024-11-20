package logic.exceptions;

public class ConnectionException extends Exception {
  private static final long serialVersionUID = 5L;
  public ConnectionException(String message) {
    super(message);
  }
}
