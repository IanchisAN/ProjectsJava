package isp.lab7.safehome.exception;

public class TooManyAttemptsException extends Exception {
    public static String message = "Too many attempts! Use master key and name to reset.";
    public TooManyAttemptsException() {
        super(message);
    }
}
