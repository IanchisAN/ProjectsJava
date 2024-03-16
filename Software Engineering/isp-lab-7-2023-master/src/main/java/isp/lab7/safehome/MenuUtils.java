package isp.lab7.safehome;

import isp.lab7.safehome.exception.InvalidPinException;
import isp.lab7.safehome.exception.TenantAlreadyExistsException;
import isp.lab7.safehome.exception.TenantNotFoundException;
import isp.lab7.safehome.exception.TooManyAttemptsException;

import java.util.Scanner;

public class MenuUtils {

    private static Scanner scanner = new Scanner(System.in);

    public static void showMainMenu(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\tDOORLOCKZ");
        System.out.println("\n\t1 - ADMIN\n\t2 - TENANT\n\n\t>");
    }

    private static void enterPinMenu(DoorLockController doorLockController) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\tDOORLOCKZ");
        System.out.println("\n\tEnter tenant name: ");
        String name = scanner.next();
        Tenant tenant = new Tenant(name);
        if (doorLockController.getValidAccess().containsKey(tenant)) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\tDOORLOCKZ");
            System.out.println("\n\tEnter PIN: ");
            String pin = scanner.next();
            try {
                DoorStatus status = doorLockController.enterPin(pin);
                if (status.equals(DoorStatus.OPEN)) {
                    doorLockController.getDoor().unlockDoor();
                }
                else {
                    doorLockController.getDoor().lockDoor();
                }
            } catch (TooManyAttemptsException | InvalidPinException e2) {
                System.out.println(e2.getMessage());
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else {
            System.out.println("No tenant found..");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void tenantMenu(DoorLockController doorLockController) {
        boolean flag = true;
        int choice;
        while (flag) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\tDOORLOCKZ");
            System.out.println("\n\t1 - Enter PIN\n\t2 - Back\n\n\t>");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    enterPinMenu(doorLockController);
                    break;
                case 2:
                    flag = false;
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

    private static void addTenantMenu(DoorLockController controller) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\tDOORLOCKZ");
        System.out.println("\tEnter new tenant name: ");
        String name = scanner.next();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\tDOORLOCKZ");
        System.out.println("\tEnter new tenant pin: ");
        String pin = scanner.next();
        try {
            controller.addTenant(pin, name);
        } catch (TenantAlreadyExistsException e) {
            System.out.println(e.getMessage());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e1) {
                throw new RuntimeException(e1);
            }
        }
    }

    private static void removeTenantMenu(DoorLockController controller) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\tDOORLOCKZ");
        System.out.println("\tEnter tenant name: ");
        String name = scanner.next();
        try {
            controller.removeTenant(name);
        } catch (TenantNotFoundException e) {
            System.out.println(e.getMessage());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e1) {
                throw new RuntimeException(e1);
            }
        }
    }

    private static void logsMenu(DoorLockController controller) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\tDOORLOCKZ");
        for (AccessLog log : controller.getAccessLogList()) {
            System.out.println(log);
        }
    }

    public static void adminMenu(DoorLockController controller) {
        boolean flag = true;
        int choice;
        while (flag) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\tDOORLOCKZ");
            System.out.println("\n\t1 - Add tenant\n\t2 - Remove tenant\n\t3 - View logs\n\t4 - Back\n\n\t>");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addTenantMenu(controller);
                    break;
                case 2:
                    removeTenantMenu(controller);
                    break;
                case 3:
                    logsMenu(controller);
                    break;
                case 4:
                    flag = false;
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
