package aut.isp.lab5.exercise1;

import isp.lab5.exercise1.*;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class Exercise1Test {

    @Test
    public void testOrder(){
        Address address = new Address("Brezoiescu 5","Cluj-Napoca");
        Customer George = new Customer("1","Pop George","0711223344");

        Product product1 = new Product("1","Dress",2.50, ProductCategory.FASHION);
        Product product2 = new Product("2","Pants",5.50,ProductCategory.FASHION);

        ArrayList<Product> products = new ArrayList<>(10);
        int expected = 0;
        int actual = products.size();
        assertEquals(expected,actual);

        Order order = new Order("1", LocalDateTime.now(),products);
        order.addProduct(product1);
        order.addProduct(product2);

        expected = 2;
        actual = products.size();
        assertEquals(expected,actual);

    }

    @Test
    public void testToString(){
        Product product1 = new Product("1","Dress",2.50, ProductCategory.FASHION);
        Product product2 = new Product("2","Pants",5.50,ProductCategory.FASHION);

        LocalDateTime date1 = LocalDateTime.of(2023, 3, 15, 9, 30);

        ArrayList<Product> products = new ArrayList<>(10);

        Order order = new Order("1", date1,products);
        order.addProduct(product1);
        order.addProduct(product2);
        String expected = "Order(OrderID = 1 date = 2023-03-15T09:30 totalPrice = 8.0)";
        String actual = order.toString();
        assertEquals(expected,actual);
    }
}