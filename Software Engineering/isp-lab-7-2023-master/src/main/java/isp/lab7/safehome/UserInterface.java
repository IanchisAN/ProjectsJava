package isp.lab7.safehome;


import java.util.Scanner;

public class UserInterface {
    DoorLockController doorLockController = new DoorLockController();
    Scanner scanner = new Scanner(System.in);

    public void generalUI(){
        System.out.println("\n******************** Welcome this is the safest home ********************");
        boolean running = true;
        String choice;


        while(running){
            System.out.println("\nSelect the user type: \n1. Admin\n2. Tenant\n3. Exit");
            choice = scanner.nextLine();

            switch (choice){
                case "1":
                    adminUI();
                    break;
                case "2":
                    tenantUI();
                    break;
                case "3":
                    System.out.println("Exiting...");
                    running = false; break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void tenantUI(){
        boolean back = true;
        while(back){
            System.out.println("\n******************** Tenant ********************\n");

            System.out.println("1. Enter pin \n2. Back");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    try{
                        try {

                            System.out.println("Enter pin: ");
                            String pin = scanner.nextLine();
                            doorLockController.enterPin(pin);

                            break;
                        }catch (Exception e){
                            System.out.println("Exception: " + e.getMessage());
                        }
                    }catch (Exception e){
                        System.out.println("Exception: " + e.getMessage());
                    }

                case "2":

                    back = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }


        }
    }

    public void adminUI() {
        boolean back = true;
        while (back) {
            System.out.println("\n******************** Admin ********************\n");
            System.out.println("1. Add Tenant\n2. Remove Tenant\n3. View Access Logs\n4. Back");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":

                    System.out.println("\n******************** New Tenant ********************\n");

                    try{
                        System.out.println("New tenant name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter pin for " + name + ":");
                        String pin = scanner.nextLine();


                        doorLockController.addTenant(pin,name);

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;


                case "2":

                    System.out.println("\n******************** Remove Tenant ********************\n");
                    try {
                        System.out.println("Enter tenant name you want to remove: ");
                        String removeName = scanner.nextLine();
                        doorLockController.removeTenant(removeName);
                    }catch (DoorLockController.TenantNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "3":
                    System.out.println("\n******************** Access Logs ********************\n");
                    System.out.println(doorLockController.getAccessLogs());

                case "4":
                    back = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        }
    }
}
