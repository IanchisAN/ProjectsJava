package isp.lab2.Exercise3SumOfIntegersRecursive;

public class Exercise3SumOfIntegersRecursive {



    public static int sumOfIntegers(int n) {
        if(n == 1)
            return 1;
        else
            return n + sumOfIntegers(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumOfIntegers(5));

    }
}
