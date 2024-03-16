package isp.lab3.exercise6;

public class VendingMachineTest {
    public static void main(String[] args) {
        VendingMachine vm = VendingMachine.getInstance();

        // Add some products to the vending machine
        vm.addProduct(1, "Coke");
        vm.addProduct(2, "Pepsi");
        vm.addProduct(3, "Sprite");

        // Display the available products
        vm.displayProducts();

        // Insert some coins
        vm.insertCoin(25);
        vm.insertCoin(25);

        // Display the current credit
        vm.displayCredit();

        // Select a product
        String result = vm.selectProduct(1);
        System.out.println(result);

        // Display the current credit again
        vm.displayCredit();
    }
}




