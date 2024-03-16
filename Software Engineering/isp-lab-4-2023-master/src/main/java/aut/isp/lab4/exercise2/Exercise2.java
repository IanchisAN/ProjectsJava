package aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder feeder1 = new FishFeeder("Stein","new model");
        feeder1.fillUp();
        feeder1.feed();
        System.out.println(feeder1.toString());
    }
}
