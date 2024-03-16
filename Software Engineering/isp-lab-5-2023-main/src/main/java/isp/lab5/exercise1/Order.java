package isp.lab5.exercise1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    // Attributes
    private String orderId;
    private LocalDateTime date;
    private double totalPrice;
    private ArrayList<Product> products;


    // constructors


    public Order(String orderId, LocalDateTime date, ArrayList<Product>products) {
        this.orderId = orderId;
        this.date = date;

        this.totalPrice = 0;
        for(Product product: products) {
            this.totalPrice += product.getPrice();
        }

        this.products = products;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public LocalDateTime getDate(){
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTotalPrice(){
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p){
        products.add(p);
        this.totalPrice += p.getPrice();
    }

    @Override
    public String toString(){
        return "Order(OrderID = " + getOrderId() +
                " date = " + getDate() +
                " totalPrice = " + getTotalPrice() +
                ")";
    }
}