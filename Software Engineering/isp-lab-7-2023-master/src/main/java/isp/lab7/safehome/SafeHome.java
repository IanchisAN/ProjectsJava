package isp.lab7.safehome;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SafeHome {

    public static void main(String[] args) {
        Door frontDoor = new Door(DoorStatus.CLOSED);
        Map<Tenant, AccessKey> validAccess = new HashMap<>();
        validAccess.put(new Tenant(ControllerInterface.MASTER_TENANT_NAME), new AccessKey(ControllerInterface.MASTER_KEY));
        validAccess.put(new Tenant("Mircea"), new AccessKey("4321"));
        validAccess.put(new Tenant("John"), new AccessKey("wick"));
        validAccess.put(new Tenant("Ben"), new AccessKey("10"));
        DoorLockController frontDoorController = new DoorLockController(validAccess, frontDoor);
        boolean flag = true;
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            MenuUtils.showMainMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    MenuUtils.adminMenu(frontDoorController);
                    break;
                case 2:
                    MenuUtils.tenantMenu(frontDoorController);
                    break;
                default:
                    System.out.println("Incorrect choice..");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
    }
}
