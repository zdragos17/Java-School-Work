package isp.lab7.safehome;

import java.rmi.AccessException;
import java.util.HashMap;
import java.util.Map;

public class DoorLockController {
    private AccesKey accesKey;
    private Tenant tenant;
    private AccessLog accessLog;
    private Door door;
    int counter = 0;
    private Map<Tenant, AccesKey> validAcces = new HashMap<>();

    public DoorLockController(Tenant tenant, Door door, AccessLog accessLog, AccesKey accesKey) {
        this.tenant = tenant;
        this.door = door;
        this.accessLog = accessLog;
        this.accesKey = accesKey;
    }

    public DoorStatus enterPin(String pin) throws InvalidPinException, TooManyAttemptsException {

        if (accesKey.getKey().equals(pin)) {
            door.unlockDoor();
            counter = 0;
            return door.getStatus();

        } else {
            counter++;
            if (counter >= 3) {
                throw new TooManyAttemptsException("prea multe incercari gresite");
            }
            door.lockDoor();
            throw new InvalidPinException("pin invalid");
        }


    }

    public void addTenant(String pin, String tenantName) throws TenantAlreadyExistsException {
        if (validAcces.containsKey(new Tenant(tenantName))) {
            throw new TenantAlreadyExistsException("deja exista");
        }
        else if (accesKey.getKey().equals(pin)) {
            validAcces.put(new Tenant(tenantName), accesKey);
        }

    }

    public void removeTenant(String name) throws TenantNotFoundException {
        if (!validAcces.containsKey(new Tenant(name))) {
            throw new TenantNotFoundException("nu exista");
        }
    else {
            validAcces.remove(new Tenant(name));
        }
    }


}
