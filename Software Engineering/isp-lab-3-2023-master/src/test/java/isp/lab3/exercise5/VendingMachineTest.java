package isp.lab3.exercise5;

public class VendingMachineTest {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

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

        // Select a product with insufficient credit
        String result1 = vm.selectProduct(1);
        System.out.println(result1);

        // Insert more coins
        vm.insertCoin(25);

        // Select a product with sufficient credit
        String result2 = vm.selectProduct(1);
        System.out.println(result2);

        // Display the current credit
        vm.displayCredit();
    }
}