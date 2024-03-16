package isp.lab3.exercise6;

import java.util.HashMap;

public class VendingMachine {
    private static VendingMachine instance = null;
    private HashMap<Integer, String> products; // Map of products and their ids
    private int credit; // Current available credit in the vending machine

    private VendingMachine() {
        // Initialize the products map and the credit to 0
        products = new HashMap<Integer, String>();
        credit = 0;
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void addProduct(int id, String name) {
        // Add a new product to the map
        products.put(id, name);
    }

    public void displayProducts() {
        // Display the available products and their ids
        System.out.println("Available Products:");
        for (Integer id : products.keySet()) {
            System.out.println(id + ": " + products.get(id));
        }
    }

    public void insertCoin(int value) {
        // Add the inserted coin to the current credit
        credit += value;
        System.out.println(value + " cents inserted.");
    }

    public String selectProduct(int id) {
        // Check if the selected product is available and deduct the price from the credit
        if (products.containsKey(id)) {
            String name = products.get(id);
            int price = getProductPrice(name);
            if (price <= credit) {
                credit -= price;
                return "You have selected " + name + ".";
            } else {
                return "Insufficient credit. Please insert " + (price - credit) + " more cents.";
            }
        } else {
            return "Invalid selection. Please try again.";
        }
    }

    public void displayCredit() {
        // Display the current available credit
        System.out.println("Current credit: " + credit + " cents.");
    }

    public void userMenu() {
        // Display the user menu options
        System.out.println("Menu:");
        System.out.println("1. Display products");
        System.out.println("2. Insert coin");
        System.out.println("3. Select product");
        System.out.println("4. Display credit");
        System.out.println("5. Quit");
    }

    private int getProductPrice(String name) {
        // Get the price of a product
        // Here we assume that all products have the same price of 50 cents
        return 50;
    }
}