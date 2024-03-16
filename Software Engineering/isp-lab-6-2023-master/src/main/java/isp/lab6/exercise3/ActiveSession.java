package isp.lab6.exercise3;

import java.util.HashMap;

public class ActiveSession {
    private String username;

    private HashMap<Product, Integer> shoppingCart;

    public ActiveSession(String username) {
        this.username = username;
        this.shoppingCart = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(HashMap<Product, Integer> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addToCart(Product product, int quantity){
        shoppingCart.put(product, quantity);
    }
}