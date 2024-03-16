package util;

import isp.lab8.airways.Route;
import isp.lab8.airways.Waypoint;

import java.io.*;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AirwaysUtils {

    public static final String workingFolder = "C:\\Uni\\ISP\\Repo Folder\\isp-labs-2023-repo-nealcos-mircea-30123\\isp-lab-8-2023-main\\Airways\\";
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void printMainMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\tAIRWAYS");
        System.out.println("\n\t1 - Show all saved routes");
        System.out.println("\t2 - Add route");
        System.out.println("\t3 - Delete route");
        System.out.println("\t4 - Exit");
        System.out.println("\n\t>");
    }

    public static List<String> getFolders() throws NullPointerException {
        List<String> folders = new ArrayList<>();
        File file = new File(workingFolder);
        for (String fileName : file.list()) {
            File current = new File(workingFolder, fileName);
            if (current.isDirectory()) {
                folders.add(fileName);
            }
        }
        return folders;
    }

    public static void routeDetails(Scanner scanner) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\tROUTES\n");
        System.out.println("\tEnter name of route: ");
        String name = scanner.next();
        File routeFolder = new File(workingFolder + name);
        ArrayList<Waypoint> waypoints = new ArrayList<>();
        try {
            for (String r : routeFolder.list()) {
                File waypointFile = new File(workingFolder + name + "\\" + r);
                try {
                    ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(waypointFile.toPath()));
                    Waypoint waypoint = (Waypoint) ois.readObject();
                    waypoints.add(waypoint);
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        }catch (NullPointerException e) {
            System.out.println("Route not found..");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException v) {
                System.out.println(v.getMessage());
            }
            return;
        }
        Route route = new Route(routeFolder.getName(), waypoints);
        route.orderWaypoints();
        boolean flag = true;
        int choice;
        while (flag) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t" + route.getName() + "\n");
            System.out.println("\t\tWaypoints:");
            System.out.println();
            System.out.print("\t");
            for (Waypoint waypoint : route.getWaypoints()) {
                if (!waypoint.equals(route.getWaypoints().get(route.getWaypoints().size()-1))) {
                    System.out.print(waypoint.getName() + " -> ");
                }
                else {
                    System.out.print(waypoint.getName());
                }
            }
            System.out.println("\n\tTotal distance: " + df.format(route.getTotalDistance()) + " KM\n");
            System.out.println("\t1 - Back");
            System.out.println("\t>");
            choice = scanner.nextInt();
            if (choice == 1) {
                flag = false;
            } else {
                System.out.println("Invalid input..");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException v) {
                    System.out.println(v.getMessage());
                }
            }
        }
    }

    public static void routeMenu(Scanner scanner) {
        List<String> routes = getFolders();
        int choice;
        boolean flag = true;
        while (flag) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\tROUTES\n");
            for (String route : routes) {
                System.out.println("\t" + route);
            }
            System.out.println("\n\t1 - View details");
            System.out.println("\t2 - Back");
            System.out.println("\t>");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    routeDetails(scanner);
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    System.out.println("\nNot a valid option..");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }

    }

    public static void addWaypoint(Route route, Scanner scanner) {
        Waypoint waypoint = new Waypoint();
        boolean flag = true;
        double latitude = 0;
        double longitude = 0;
        int altitude = 0;
        while (flag) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\tADD WAYPOINT\n");
            System.out.println("\tEnter waypoint name: ");
            String name = scanner.next();
            System.out.println("\tEnter latitude: ");
            try {
                latitude = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type. User should enter a double value.");
                flag = false;
            }
            System.out.println("\tEnter longitude: ");
            try {
                longitude = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type. User should enter a double value.");
                flag = false;
            }
            System.out.println("\tEnter altitude: ");
            try {
                altitude = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type. User should enter a double value.");
                flag = false;
            }
            waypoint.setName(name);
            waypoint.setLongitude(longitude);
            waypoint.setLatitude(latitude);
            waypoint.setAltitude(altitude);
            route.getWaypoints().add(waypoint);
            try {
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(workingFolder + route.getName() + '\\' + name));
                outputStream.writeObject(waypoint);
                outputStream.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            flag = false;
        }
    }

    public static Route createRoute(Scanner scanner) {
        boolean flag = true;
        boolean found;
        int choice = -1;
        Route route = new Route();
        List<String> routes = getFolders();
        while (flag) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\tADD ROUTE");
            System.out.println("\n\tEnter route name:");
            found = false;
            String name = scanner.next();
            for (String r : routes) {
                if (r.equals(name)) {
                    found = true;
                    System.out.println("\n\tRoute with same name already exists!");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            if (!found) {
                File newRoute = new File(workingFolder + name);
                newRoute.mkdirs();
                route.setName(name);
                System.out.println("\n\tSuccessfully created folder for route " + name + " !");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                flag = false;
            }
        }
        flag = true;
        while (flag) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t" + route.getName() + "\n");
            System.out.println("\t\tCurrent waypoints:");
            if (route.getWaypoints().isEmpty()) {
                System.out.println("\tThis route has no waypoints.");
            }
            else {
                System.out.println();
                System.out.print('\t');
                for (Waypoint waypoint : route.getWaypoints()) {
                    if (!waypoint.equals(route.getWaypoints().get(route.getWaypoints().size()-1))) {
                        System.out.print(waypoint.getName() + " -> ");
                    }
                    else {
                        System.out.print(waypoint.getName());
                    }
                }
            }
            System.out.println("\n\n\t1 - Add waypoint");
            System.out.println("\t2 - Back");
            System.out.println("\t>");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type. User should enter a double value.");
                flag = false;
            }

            switch (choice) {
                case 1:
                    addWaypoint(route,scanner);
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
        return route;
    }

    public static void deleteRoute(Scanner scanner) {
        boolean flag = true;
        String name;
        while (flag) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\tDELETE ROUTE");
            System.out.println("\n\tEnter name of route to delete:");
            name = scanner.next();
            File folder = new File(workingFolder + name);
            String[] files = folder.list();
            try {
                for (String file : files) {
                    File s = new File(workingFolder + name, file);
                    s.delete();
                }
            }catch (NullPointerException e) {
                System.out.println("\tRoute not found..");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException v) {
                    System.out.println(v.getMessage());
                }
                break;
            }
            folder.delete();
            System.out.println("\tRoute successfully deleted!");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException v) {
                System.out.println(v.getMessage());
            }
            flag = false;
        }
    }

}
