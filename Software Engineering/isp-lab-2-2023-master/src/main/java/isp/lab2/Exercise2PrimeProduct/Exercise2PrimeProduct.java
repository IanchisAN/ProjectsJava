package isp.lab2.Exercise2PrimeProduct;

import java.util.Scanner;

public class Exercise2PrimeProduct {

    public static boolean prime(int x) {
        for(int i = 2; i < x; i++) {
            if(x % i == 0)
                return false;
        }
        return true;
    }
    public static long getPrimeProduct(int n, int m){
        if(n > m) {
            int aux = n;
            n = m;
            m = aux;
        }
        int product = 1;
        for(int i = n; i <= m; i++) {
            if(prime(i))
                product = product * i;
        }
        return product;
    }

    public static int readfromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        return number;
    }

    public static void main(String[] args) {
        System.out.println("The product of the first 10 prime numbers is: " + getPrimeProduct(1, 10));
        System.out.println("The product of prime numbers between m and n: " + getPrimeProduct(readfromConsoleInt(), readfromConsoleInt()));
    }

}
