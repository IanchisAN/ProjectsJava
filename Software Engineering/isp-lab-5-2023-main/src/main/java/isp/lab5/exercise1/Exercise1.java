package isp.lab5.exercise1;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Exercise1 {

    public static void main(String[] args) {

        Address address = new Address("Brezoiescu 5","Cluj-Napoca");
        Customer George = new Customer("1","Pop George","0711223344");

        LocalDateTime date1 = LocalDateTime.of(2023, 3, 15, 9, 30);

        Product product1 = new Product("1","Dress",2.50,ProductCategory.FASHION);

        Product product2 = new Product("2","Pants",5.50,ProductCategory.FASHION);

        Product product3 = new Product("3","Cable",1.00,ProductCategory.ELECTRONICS);

        Product product4 = new Product("4","Axe",50.00,ProductCategory.HOME_AND_GARDEN);

        Product product5 = new Product("5","Eyeliner",2.20,ProductCategory.BEAUTY);

        Product product6 = new Product("6","Puppet",2.33,ProductCategory.TOYS);


        ArrayList<Product> products = new ArrayList<>(10);


        Order order = new Order("1",date1,products);
        order.addProduct(product1);
        order.addProduct(product2);
        order.addProduct(product3);
        order.addProduct(product4);
        order.addProduct(product5);
        order.addProduct(product6);


        System.out.println(order.toString());

    }
}
