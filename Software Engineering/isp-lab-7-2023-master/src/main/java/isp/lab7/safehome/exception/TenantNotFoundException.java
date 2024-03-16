package isp.lab7.safehome.exception;

public class TenantNotFoundException extends Exception {
    public static String message = "Tenant not found!";
    public TenantNotFoundException() {
        super(message);
    }
}
