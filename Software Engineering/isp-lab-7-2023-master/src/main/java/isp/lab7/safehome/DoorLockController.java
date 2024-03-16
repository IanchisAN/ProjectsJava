package isp.lab7.safehome;


import isp.lab7.safehome.exception.InvalidPinException;
import isp.lab7.safehome.exception.TenantAlreadyExistsException;
import isp.lab7.safehome.exception.TenantNotFoundException;
import isp.lab7.safehome.exception.TooManyAttemptsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DoorLockController implements ControllerInterface {
    private Map<Tenant, AccessKey> validAccess;
    private List<AccessLog> accessLogList = new ArrayList<>();
    private Door door;
    private static Integer attempts = 0;

    public DoorLockController(Map<Tenant, AccessKey> validAccess, Door door) {
        this.validAccess = validAccess;
        this.door = door;
    }

    public Map<Tenant, AccessKey> getValidAccess() {
        return validAccess;
    }

    public void setValidAccess(Map<Tenant, AccessKey> validAccess) {
        this.validAccess = validAccess;
    }

    public List<AccessLog> getAccessLogList() {
        return accessLogList;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    @Override
    public DoorStatus enterPin(String pin) throws InvalidPinException, TooManyAttemptsException {
        AccessKey key = new AccessKey(pin);
        if(key.getKey().equals(ControllerInterface.MASTER_KEY)) {
            AccessLog accessLog = new AccessLog(ControllerInterface.MASTER_TENANT_NAME, LocalDateTime.now(), "Used master key", door.getStatus(), null);
            this.accessLogList.add(accessLog);
            attempts = 0;
            return DoorStatus.OPEN;
        }
        else if (attempts > 3) {
            Tenant tenant = new Tenant();
            for (Map.Entry<Tenant, AccessKey> entry : validAccess.entrySet()) {
                if (entry.getValue().equals(key)) {
                    tenant = entry.getKey();
                    break;
                }
            }
            AccessLog log = new AccessLog(tenant.getName(), LocalDateTime.now(), "Enter Pin", door.getStatus(), TooManyAttemptsException.message);
            accessLogList.add(log);
            throw new TooManyAttemptsException();
        }
        else if (!validAccess.containsValue(key)) {
            AccessLog accessLog = new AccessLog("null", LocalDateTime.now(), "Enter Pin", door.getStatus(), InvalidPinException.message);
            this.accessLogList.add(accessLog);
            attempts++;
            throw new InvalidPinException();
        }
        else if (door.getStatus().equals(DoorStatus.OPEN)) {
            Tenant tenant = new Tenant();
            for (Map.Entry<Tenant, AccessKey> entry : validAccess.entrySet()) {
                if (entry.getValue().equals(key)) {
                    tenant = entry.getKey();
                    break;
                }
            }
            AccessLog log = new AccessLog(tenant.getName(), LocalDateTime.now(), "Closed door.", door.getStatus(), "No error message.");
            accessLogList.add(log);
            return DoorStatus.CLOSED;
        }
        else {
            Tenant tenant = new Tenant();
            for (Map.Entry<Tenant, AccessKey> entry : validAccess.entrySet()) {
                if (entry.getValue().equals(key)) {
                    tenant = entry.getKey();
                    break;
                }
            }
            AccessLog log = new AccessLog(tenant.getName(), LocalDateTime.now(), "Opened door.", door.getStatus(), "No error message.");
            accessLogList.add(log);
            return DoorStatus.OPEN;
        }
    }

    @Override
    public void addTenant(String pin, String name) throws TenantAlreadyExistsException {
        Tenant tenant = new Tenant(name);
        if (validAccess.containsKey(tenant)) {
            AccessLog log = new AccessLog(name, LocalDateTime.now(), "Add tenant", door.getStatus(), TenantAlreadyExistsException.message);
            accessLogList.add(log);
            throw new TenantAlreadyExistsException();
        }
        AccessKey key = new AccessKey(pin);
        validAccess.put(tenant, key);
        AccessLog log = new AccessLog(name, LocalDateTime.now(), "Add tenant", door.getStatus(), "No error message.");
        accessLogList.add(log);
    }

    @Override
    public void removeTenant(String name) throws TenantNotFoundException {
        Tenant tenant = new Tenant(name);
        if (!validAccess.containsKey(tenant)) {
            AccessLog log = new AccessLog(name, LocalDateTime.now(), "Remove tenant", door.getStatus(), TenantNotFoundException.message);
            accessLogList.add(log);
            throw new TenantNotFoundException();
        }
        validAccess.remove(tenant);
        AccessLog log = new AccessLog(name, LocalDateTime.now(), "Remove tenant", door.getStatus(), "No error message.");
        accessLogList.add(log);
    }
}
