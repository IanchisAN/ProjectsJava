package isp.lab7.safehome;

import java.time.LocalDateTime;

public class AccessLog {

    private String tenantName;
    private LocalDateTime dateTime;
    private String operation;
    private DoorStatus doorStatus;
    private String errorMessage;

    public AccessLog() {
    }

    public AccessLog(String tenantName, LocalDateTime dateTime, String operation, DoorStatus doorStatus, String errorMessage) {
        this.tenantName = tenantName;
        this.dateTime = dateTime;
        this.operation = operation;
        this.doorStatus = doorStatus;
        this.errorMessage = errorMessage;
    }

    public String getTenantName() {
        return tenantName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getOperation() {
        return operation;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "\n\nLOG DATE: " + dateTime + "\n" +
                "TENANT: " + tenantName + "\n" +
                "OPERATION: " + operation + "\n" +
                "DOOR STATUS: " + doorStatus + "\n" +
                "ERROR MESSAGE: " + errorMessage;
    }
}
