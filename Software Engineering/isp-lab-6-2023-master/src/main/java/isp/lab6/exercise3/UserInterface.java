package isp.lab6.exercise3;

import java.util.Comparator;
import java.util.Scanner;

public class UserInterface {
    private LoginSystem loginSystem;
    private OnlineStore onlineStore;

    public void loadInterface(){
        OnlineStore onlineStore = new OnlineStore();
        LoginSystem loginSystem = new LoginSystem(onlineStore);

        Scanner sc = new Scanner(System.in);

        boolean ok = true;
        boolean right = true;

        while(right = true ){

            System.out.println("Hello! What do you want to do?");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Display the products");
            System.out.println("4. Display the sorted products");
            System.out.println("5. Order products");
            System.out.println("6. Checkout");
            System.out.println("7. Logout");


            int choice = sc.nextInt();
            String name = "";

            switch (choice){
                case 1:
                    System.out.println("What do you want your username and password to be: ");
                    String username = sc.nextLine();
                    String password = sc.nextLine();
                    loginSystem.register(username,password);
                    break;
                case 2:
                    System.out.println("What's your username and password? :");
                    name = sc.nextLine();
                    String password1 = sc.nextLine();
                    loginSystem.login(name,password1);
                    break;
                case 3:
                    System.out.println(onlineStore.getProducts());
                    break;
                case 4:
                    Comparator<Product> sortByPrice = Comparator.comparing(Product::getPrice);
                    System.out.println(onlineStore.getProductsSorted(sortByPrice));
                    break;
                case 5:
                    System.out.println("Please enter a product from the list (1-Bread,2-WaterBottle,3-Soda,4-Butter, 5-Cola)");
                    int choice2 = sc.nextInt();
                    System.out.println("Also select the quantity:");
                    int quantity = sc.nextInt();
                    if (choice2 == 1) {
                        onlineStore.addToCart(name, new Product("Bread", 10), quantity);
                    }
                    if (choice2 == 2) {
                        onlineStore.addToCart(name, new Product("WaterBottle", 5), quantity);
                    }
                    if (choice2 == 3) {
                        onlineStore.addToCart(name, new Product("Soda", 7), quantity);
                    }
                    if (choice2 == 4) {
                        onlineStore.addToCart(name, new Product("Butter", 15), quantity);
                    }
                    break;
                case 6:
                    System.out.println(onlineStore.checkout(name));
                    break;
                case 7:
                    right = false;
                    return;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }

    }
}