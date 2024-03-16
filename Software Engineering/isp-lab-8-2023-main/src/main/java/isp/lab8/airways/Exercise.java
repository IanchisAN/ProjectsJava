package isp.lab8.airways;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static util.AirwaysUtils.*;

public class Exercise {
    public static void main(String[] args) {
        List<Route> routes = new ArrayList<>();
        boolean flag = true;
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            printMainMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    routeMenu(scanner);
                    break;
                case 2:
                    routes.add(createRoute(scanner));
                    break;
                case 3:
                    deleteRoute(scanner);
                    break;
                case 4:
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
}
