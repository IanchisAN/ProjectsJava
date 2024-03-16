package isp.lab7.safehome.exception;

public class InvalidPinException extends Exception{
    public static String message = "Pin is invalid!";
    public InvalidPinException() {
        super(message);
    }
}
