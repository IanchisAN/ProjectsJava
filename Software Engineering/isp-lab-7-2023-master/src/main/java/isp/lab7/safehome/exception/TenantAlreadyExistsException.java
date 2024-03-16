package isp.lab7.safehome.exception;

public class TenantAlreadyExistsException extends Exception {
    public static String message = "Tenant already exists!";
    public TenantAlreadyExistsException() {
        super(message);
    }
}
