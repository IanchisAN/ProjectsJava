package aut.isp.lab4.exercise1;

public class Exercise1 {

    public static void main(String[] args) {
        //create an object
        AquariumController aquarium1 = new AquariumController("Steins", "M321");
        aquarium1.setCurrentTime(7);
        System.out.println(aquarium1.toString());
    }
}