package isp.lab6.exercise3;
import java.util.*;
import java.util.stream.Collectors;


public class OnlineStore {

    //attributes
    private List<Product> products;
    public HashMap<String, ActiveSession> sessions;

    //methods
    public OnlineStore() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product("Bread",10),
                new Product("WaterBottle", 5),
                new Product("Soda", 7),
                new Product("Butter", 15),
                new Product("Cola", 12)
        ));
        this.sessions = new HashMap<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getProductsSorted(Comparator<Product> sortCriteria){

        List<Product> sortedProducts = new ArrayList<>(this.products);
        sortedProducts.sort(sortCriteria);
        return sortedProducts;
    }

    public List<Product> getProductsSortedSecond(){
        return this.products.stream().sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
    }

    public void addToCart(String username, Product product, int quantity){
        try {
            sessions.get(username).addToCart(product, quantity);
        } catch (NullPointerException nullPointerException){
            System.out.println("Today you're not buying anything");}
    }

    void addSession(String username){
        ActiveSession activeSession = new ActiveSession(username);
        sessions.put(username, activeSession);
    }

    void removeSession(String username){
        ActiveSession activeSession = new ActiveSession(username);
        sessions.remove(username, activeSession);
    }

    public int checkout(String username){
        int sum = 0;
        try {
            Map<Product, Integer> shoppingCart = sessions.get(username).getShoppingCart();
            for (Product product: shoppingCart.keySet()) {
                sum += product.getPrice() * shoppingCart.get(product);
            }
            return sum;
        } catch (NullPointerException nullPointerException){
            System.out.println("Today you're not buying anything");
            return 0;        }
    }

}